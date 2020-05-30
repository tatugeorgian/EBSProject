package topology;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.topology.TopologyBuilder;

public class App {

    private static final String PUBLISHER_ID = "publisher";
    private static final String SUBSCRIBER_ID = "subscriber";
    private static final String BOLT_ID = "broker";

    public static void main(String[] args) {
        TopologyBuilder builder = new TopologyBuilder();

        //builder.setSpout(PUBLISHER_ID, new Publisher(), 1);
        builder.setSpout(SUBSCRIBER_ID, new Subscriber(), 1);
        builder.setBolt(BOLT_ID, new Broker(), 1)
                .shuffleGrouping(SUBSCRIBER_ID).directGrouping(SUBSCRIBER_ID, "secondary");

        // fine tuning
        Config config = new Config();

        LocalCluster cluster = new LocalCluster();
        StormTopology topology = builder.createTopology();

        config.put(Config.TOPOLOGY_EXECUTOR_RECEIVE_BUFFER_SIZE, 1024);
        config.put(Config.TOPOLOGY_DISRUPTOR_BATCH_SIZE, 1);
        config.setDebug(true);

        cluster.submitTopology("stocks_topology", config, topology);

        try {
            Thread.sleep(25_000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cluster.killTopology("stocks_topology");
        cluster.shutdown();
    }
}
