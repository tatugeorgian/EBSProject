package topology;

import generator.*;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.*;

public class Subscriber extends BaseRichSpout {

    static int subTotalCount;
    private SpoutOutputCollector collector;
    private List<Subscription> subscriptions;
    private int subscriptionsIndex;
    private String _id;

    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        collector = spoutOutputCollector;
        _id = "terminal_" + topologyContext.getThisComponentId();
        subscriptionsIndex = 0;

        Generator generator = new GeneratorImpl();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2030, Calendar.JANUARY, 1);
        Date endDate = new Date(calendar.getTimeInMillis()); // 1 jan 2030
        subscriptions = generator.generateSubscriptions(new SubscriptionGenerationParams(new PublicationGenerationParams(),
                endDate));
        subTotalCount = subscriptions.size();
    }

    @Override
    public void nextTuple() {
        if (subscriptionsIndex < subTotalCount) {
            collector.emit(new Values(ProtoSerializer.serializeSubscription(subscriptions.get(subscriptionsIndex++).getFilters(), _id)));
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("subscription"));
    }
}
