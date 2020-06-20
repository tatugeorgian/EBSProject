package topology;

import generator.Generator;
import generator.GeneratorImpl;
import generator.Publication;
import generator.PublicationGenerationParams;
import messages.CompanyProto;
import messages.PublicationProto;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import utils.TopologyLogger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Publisher extends BaseRichSpout {

    private List<Publication> publications;
    private SpoutOutputCollector collector;
    private int publicationIndex;

    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        collector = spoutOutputCollector;
        Generator generator = new GeneratorImpl();
        publications = generator.generatePublications(new PublicationGenerationParams());
        publicationIndex = 0;
    }

    @Override
    public void nextTuple() {
        if (publicationIndex == 0) {
            while (Broker.ackSubs < App.SUB_NO * Subscriber.subTotalCount * 0.99) { // 0.99 is for the margin of error for cases when tuples are missed
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Publication publication = publications.get(publicationIndex++);
        publication.setUuid(UUID.randomUUID());
        collector.emit(new Values(publication));
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("./sendingTimes.txt", true));
            out.write(String.valueOf(System.currentTimeMillis()) + ' ' + publication.getUuid() + '\n');
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (publicationIndex == publications.size()) {
            publicationIndex = 0;
        }

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("publication"));
    }
}
