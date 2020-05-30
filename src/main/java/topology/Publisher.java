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
    }

    @Override
    public void nextTuple() {
        Publication nextPublication = publications.get(publicationIndex);
        collector.emit(new Values(nextPublication.getCompany(), nextPublication.getStockValue(), nextPublication.getChange(),
                nextPublication.getVariation(), nextPublication.getDate()));
        publicationIndex++;
        if (publicationIndex == publications.size()) {
            publicationIndex = 0;
        }

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("company", "stockValue", "change", "variation", "date"));
    }
}
