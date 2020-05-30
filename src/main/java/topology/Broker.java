package topology;

import generator.Filter;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;

import java.util.List;
import java.util.Map;

public class Broker extends BaseRichBolt {

    private OutputCollector collector;
    private int index;


    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        collector = outputCollector;
    }

    @Override
    public void execute(Tuple tuple) {
        if (tuple.getSourceStreamId().equals("secondary")) {
            Integer globalcount = tuple.getIntegerByField("subCount");
            System.out.println("----- Terminal Bolt globalcount: " + globalcount);
        }
        else {
            System.out.println("===" + ((List<Filter>) tuple.getValueByField("filters")).toString());
            System.out.println("===" + index++);
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }

    @Override
    public void cleanup() {
        System.out.println("------------------STOP-------------------");
        super.cleanup();
    }
}
