package im.wangbo.java.usecases.services;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-30 by Elvis Wang
 */
public class ServiceGridApp {

    public static void main(String[] args) throws Exception {
        //
        // remote nodes need to be started with PeerClassLoadingEnabled
        //

        final IgniteConfiguration conf = new IgniteConfiguration();
        conf.setPeerClassLoadingEnabled(true);
        try (Ignite ignite = Ignition.start(conf)) {
            // Deploying a single instance of the Weather Service
            // in the whole cluster.
            ignite.services().deployClusterSingleton("WeatherService",
                new WeatherServiceImpl());

            // Requesting current weather for London.
            WeatherService service = ignite.services().service("WeatherService");

            String forecast = service.getCurrentTemperature("Shanghai", "Asia");

            System.out.println("Weather forecast in London:" + forecast);
        }
    }
}
