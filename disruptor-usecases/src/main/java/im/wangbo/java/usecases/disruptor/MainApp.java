package im.wangbo.java.usecases.disruptor;

import com.lmax.disruptor.EventTranslatorTwoArg;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.time.OffsetDateTime;
import java.util.logging.Logger;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class MainApp {
    private static class TestEvent {
        private String name;
        private long score;
        private OffsetDateTime createdAt;
        private OffsetDateTime lastUpdatedAt;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getScore() {
            return score;
        }

        public void setScore(long score) {
            this.score = score;
        }

        public OffsetDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public OffsetDateTime getLastUpdatedAt() {
            return lastUpdatedAt;
        }

        public void setLastUpdatedAt(OffsetDateTime lastUpdatedAt) {
            this.lastUpdatedAt = lastUpdatedAt;
        }

        @Override
        public String toString() {
            return "TestEvent{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", createdAt=" + createdAt +
                ", lastUpdatedAt=" + lastUpdatedAt +
                '}';
        }
    }

    private static final Logger INFO1 = Logger.getLogger("info_1");
    private static final Logger INFO2 = Logger.getLogger("info_2");
    private static final Logger INFO3 = Logger.getLogger("info_3");
    private static final Logger WARN_1 = Logger.getLogger("warn_1");
    private static final Logger WARN_2 = Logger.getLogger("warn_2");

    private static final Logger APP = Logger.getLogger(MainApp.class.getName());

    public static void main(String[] args) {
        final Disruptor<TestEvent> disruptor = new Disruptor<TestEvent>(
            TestEvent::new, 1024, DaemonThreadFactory.INSTANCE
        );

        final EventHandlerGroup<TestEvent> g = disruptor.handleEventsWith(
            (_e, _seq, _end) -> INFO1.info(() -> "INFO01 " + _e.toString()),
            (_e, _seq, _end) -> INFO2.info(() -> "INFO02 " + _e.toString())
        );
        g.handleEventsWith(
            (_e, _seq, _end) -> INFO3.info(() -> "INFO03 " + _e.toString())
        ).then(
            (_e, _seq, _end) -> WARN_1.warning(() -> "WARN01 " + _e.toString()),
            (_e, _seq, _end) -> WARN_2.warning(() -> "WARN02 " + _e.toString())
        );

        disruptor.start();

        APP.info("Disruptor created and setup");

        final EventTranslatorTwoArg<TestEvent, String, Long> translator = (_e, _seq, _name, _score) -> {
            _e.setName(_name);
            _e.setScore(_score);

            final OffsetDateTime now = OffsetDateTime.now();
            _e.setCreatedAt(now);
            _e.setLastUpdatedAt(now);
        };

        for (int i = 0; i < 100; i++) {
            disruptor.publishEvent(translator, "name " + i, (long) i);
        }

        disruptor.shutdown();
    }
}
