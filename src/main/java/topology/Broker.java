package topology;

import generator.Filter;
import generator.Publication;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import utils.TopologyLogger;
import utils.PubFilter;

import java.util.*;

public class Broker extends BaseRichBolt {

    static int ackSubs = 0;
    private OutputCollector collector;
    private Map<String, Set<List<Filter>>> subscriptions = new HashMap<>();
    private Map<String, Boolean> matches = new HashMap<>();
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
        } else if (tuple.getFields().contains("publication")) {
            ++ackPubs;
            Publication pub = (Publication) tuple.getValueByField("publication");

            for (String key : subscriptions.keySet()){
                matches.put(key, false);
            }

            if (pub != null){
                for (Map.Entry<String, Set<List<Filter>>> kv : subscriptions.entrySet()) {
                    if (PubFilter.matchPub(pub, kv.getValue())){
                        matches.put(kv.getKey(), true);
                    }
                }

                for (Map.Entry<String, Boolean> kv : matches.entrySet()){
                    if (kv.getValue()){
                        collector.emit(kv.getKey(), new Values(pub));
                    }
                }
            }
        }

        //collector.ack(tuple);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declareStream(App.TERM_SUB_1_ID, new Fields("consumer_pub"));
        outputFieldsDeclarer.declareStream(App.TERM_SUB_2_ID, new Fields("consumer_pub"));
        outputFieldsDeclarer.declareStream(App.TERM_SUB_3_ID, new Fields("consumer_pub"));
    }

    @Override
    public void cleanup() {
        for (Map.Entry<String, Set<List<Filter>>> kv : subscriptions.entrySet()) {
            TopologyLogger.log("On broker task:" + _thisTaskId + "   " + kv.getKey() + "   " + kv.getValue().size());
        }
        TopologyLogger.log("Total global subs: " + ackSubs);
        TopologyLogger.log("On broker task:" + _thisTaskId + "   " + "Total global pubs: " + ackPubs + "\n");
    }
}
