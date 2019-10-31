package im.wangbo.java.usecases.cache;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-30 by Elvis Wang
 */
public class DataGridApp {

    public static void main(String[] args) throws Exception {
        final IgniteConfiguration conf = new IgniteConfiguration();
        conf.setPeerClassLoadingEnabled(true);
        try (Ignite ignite = Ignition.start(conf)) {
            IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName");

            // Store keys in cache (values will end up on different cache nodes).
            for (int i = 0; i < 10; i++) {
                cache.put(i, Integer.toString(i));
            }

            for (int i = 0; i < 10; i++) {
                System.out.println("Got [key=" + i + ", val=" + cache.get(i) + ']');
            }
        }
    }
}
