package topology;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.topology.TopologyBuilder;

public class App {

    static final int SUB_NO = 3;
    private static final String PUBLISHER_ID = "publisher";
    private static final String SUB_1_ID = "subscriber_1", SUB_2_ID = "subscriber_2", SUB_3_ID = "subscriber_3";
    private static final String BOLT_ID = "broker";

    public static void main(String[] args) {
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout(PUBLISHER_ID, new Publisher(), 1);
        builder.setSpout(SUB_1_ID, new Subscriber("sub1"), 1);
        builder.setSpout(SUB_2_ID, new Subscriber("sub2"), 1);
        builder.setSpout(SUB_3_ID, new Subscriber("sub3"), 1);

        builder.setBolt(BOLT_ID, new Broker(), 3)
                .shuffleGrouping(SUB_1_ID).shuffleGrouping(SUB_2_ID).shuffleGrouping(SUB_3_ID)
                .allGrouping(PUBLISHER_ID);

        // fine tuning
        Config config = new Config();

        LocalCluster cluster = new LocalCluster();
        StormTopology topology = builder.createTopology();

        config.put(Config.TOPOLOGY_EXECUTOR_RECEIVE_BUFFER_SIZE, 1024);
        config.put(Config.TOPOLOGY_DISRUPTOR_BATCH_SIZE, 1);
        config.setDebug(true);

        cluster.submitTopology("stocks_topology", config, topology);

        try {
            Thread.sleep(1000 * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cluster.killTopology("stocks_topology");
        cluster.shutdown();
    }
}
