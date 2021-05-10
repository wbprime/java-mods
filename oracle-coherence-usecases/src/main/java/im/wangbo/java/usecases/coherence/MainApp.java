package im.wangbo.java.usecases.coherence;

import com.tangosol.net.NamedMap;
import com.tangosol.net.Session;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class MainApp {
    public static void main(String[] args) {
        System.setProperty("coherence.distributed.localstorage", "true");

        final Logger log = Logger.getLogger("main");
        {
            try (final Session session = Session.create()) {
                NamedMap<String, String> map = session.getCache("testing");

                log.info(String.format("Accessing map \"%s\" containing %d entries\n",
                    map.getName(),
                    map.size()));

                map.put("english", "Hello");
                map.put("spanish", "Hola");
                map.put("french", "Bonjour");

                log.info(String.format("Accessing map \"%s\" containing %d entries\n",
                    map.getName(),
                    map.size()));

                // list
                map.entrySet().forEach(_v -> log.info(_v::toString));
            } catch (Exception ex) {
                log.log(Level.SEVERE, "Coherence session created failed", ex);
            }
        }
    }
}
