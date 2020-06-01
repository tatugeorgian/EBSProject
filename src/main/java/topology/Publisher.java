package topology;

import generator.Generator;
import generator.GeneratorImpl;
import generator.Publication;
import generator.PublicationGenerationParams;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.List;
import java.util.Map;

public class Publisher extends BaseRichSpout {

    private SpoutOutputCollector collector;
    public List<Publication> publications;
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
        if (publicationIndex == 0){
            while(Broker.ackSubs < App.SUB_NO * Subscriber.subTotalCount * 0.99){ // 0.99 is for the margin of error for cases when tuples are missed
                try {
                    System.out.println("======" + Subscriber.subTotalCount);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        Publication pub = publications.get(publicationIndex);
        collector.emit(new Values(pub.getCompany(), pub.getStockValue(), pub.getChange(), pub.getVariation(), pub.getDate()));
        ++publicationIndex;
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
        outputFieldsDeclarer.declare(new Fields("company", "stockValue", "change", "variation", "date"));
    }
}
