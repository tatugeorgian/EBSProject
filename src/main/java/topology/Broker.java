package topology;

import generator.Filter;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;
import utils.TopologyLogger;

import java.util.*;

public class Broker extends BaseRichBolt {

    static int ackSubs = 0;
    private OutputCollector collector;
    private Map<String, Set<List<Filter>>> subscriptions = new HashMap<>();
    private int _thisTaskId, ackPubs = 0;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        collector = outputCollector;
        ackPubs = 0;
        _thisTaskId = topologyContext.getThisTaskId();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void execute(Tuple tuple) {

        if (tuple.getFields().contains("filters")) {
            synchronized (this) {
                ++ackSubs;
            }

            List<Filter> sub = (List<Filter>) tuple.getValueByField("filters");
            String id = (String) tuple.getValueByField("terminal_id");

            if (sub != null && id != null) {
                Set<List<Filter>> temp_sub_set;
                if (!subscriptions.containsKey(id)) {
                    temp_sub_set = new HashSet<>();
                    temp_sub_set.add(sub);
                } else {
                    temp_sub_set = subscriptions.get(id);
                    temp_sub_set.add(sub);
                }

                subscriptions.put(id, temp_sub_set);
            }
        } else if (tuple.getFields().contains("company")) {
            ++ackPubs;
        }

        //collector.ack(tuple);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }

    @Override
    public void cleanup() {
        System.out.println("---STOP---");
        for (Map.Entry<String, Set<List<Filter>>> kv : subscriptions.entrySet()) {
            TopologyLogger.log("On broker task:" + _thisTaskId + "   " + kv.getKey() + "   " + kv.getValue().size());
        }
        TopologyLogger.log("Total global subs: " + ackSubs);
        TopologyLogger.log("On broker task:" + _thisTaskId + "   " + "Total global pubs: " + ackPubs + "\n");
    }
}
