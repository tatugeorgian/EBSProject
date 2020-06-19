package topology;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;
import utils.TopologyLogger;

import java.util.List;
import java.util.Map;

public class TerminalSub extends BaseRichBolt {
    private OutputCollector _collector;
    private String compId;
    private int pub_no;

    @Override
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        _collector = collector;
        compId = context.getThisComponentId();
        pub_no = 0;
    }

    @Override
    public void execute(Tuple input) {
        if (input.getFields().contains("consumer_pub")){
            List<Byte> bytes = (List<Byte>)input.getValueByField("consumer_pub");

            if (bytes != null){
                ++pub_no;
            }
        }
    }

    @Override
    public void cleanup() {
        TopologyLogger.log("On terminal node: " + compId + ", received pubs: " + pub_no);
        super.cleanup();
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }
}
