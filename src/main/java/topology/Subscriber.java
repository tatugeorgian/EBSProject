package topology;

import generator.*;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Subscriber extends BaseRichSpout {

    private SpoutOutputCollector collector;
    private List<Subscription> subscriptions;
    private int subscriptionsIndex;
    private List<Integer> tasks;

    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        collector = spoutOutputCollector;
        Generator generator = new GeneratorImpl();
        Date endDate = new Date(130, 0, 1); // 1 jan 2030
        subscriptions = generator.generateSubscriptions(new SubscriptionGenerationParams(new PublicationGenerationParams(),
                endDate));
        tasks = topologyContext.getComponentTasks("broker");
    }

    @Override
    public void nextTuple() {
        Subscription nextSubscription = subscriptions.get(subscriptionsIndex);
        List<Filter> filters = nextSubscription.getFilters();

        collector.emit(new Values(filters));
        subscriptionsIndex++;
        collector.emitDirect(tasks.get(0), "secondary", new Values(subscriptionsIndex));
        if (subscriptionsIndex == subscriptions.size()) {
            subscriptionsIndex = 0;
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
        outputFieldsDeclarer.declare(new Fields("filters"));
        outputFieldsDeclarer.declareStream("secondary", true, new Fields("subCount"));
    }
}
