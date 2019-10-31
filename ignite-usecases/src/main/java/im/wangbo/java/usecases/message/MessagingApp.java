package im.wangbo.java.usecases.message;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteMessaging;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-30 by Elvis Wang
 */
public class MessagingApp {

    public static void main(String[] args) throws Exception {
        final IgniteConfiguration conf = new IgniteConfiguration();
        conf.setPeerClassLoadingEnabled(true);
        try (Ignite ignite = Ignition.start(conf)) {
            final IgniteMessaging messaging = ignite.message();

            messaging.remoteListen("MyOrderedTopic", (nodeId, msg) -> {
//                System.out.println(
//                    "Received ordered message [msg=" + msg + ", from=" + nodeId + ']');

                messaging.send("AckMessage", msg + "-" + System.nanoTime());

                return true; // Return true to continue listening.
            });

            messaging.localListen("AckMessage", (uuid, msg) -> {
                System.out.println(
                    "Acked ordered message [msg=" + msg + ", from=" + uuid + ']');
                return true;
            });

            // Send ordered messages to remote nodes.
            for (int i = 0; i < 10; i++) {
                messaging.sendOrdered("MyOrderedTopic", i + "_" + System.nanoTime(), 0);
            }
        }
    }
}
