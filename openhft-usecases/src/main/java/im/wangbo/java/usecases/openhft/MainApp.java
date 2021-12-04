package im.wangbo.java.usecases.openhft;

import net.openhft.chronicle.map.ChronicleMap;
import net.openhft.chronicle.map.ChronicleMapBuilder;
import net.openhft.chronicle.queue.RollCycles;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueue;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.LongAdder;

public class MainApp
    {
    private static final Logger L = LogManager.getLogger();

    public static void main(String[] args) throws Exception
        {
        testJulLog();
        testDoNothing();
        testChronicleQueue();
        }

    private static void testConcurrentMap(final ConcurrentMap<String, String> map) throws IOException
        {
        for (int i = 0; i < 100000; i++)
            {
            map.put(UUID.randomUUID().toString(), "" + i);
            }
        }

    static interface MsgConsumer
        {
        public void onMessage(final String msg);
        }

    private static void testOnMessage(final String name, final MsgConsumer consumer) throws InterruptedException
        {
        final LongAdder nanos = new LongAdder();

        final Runnable r = () -> {
        for (int i = 0; i < 100000; i++)
            {
            long n = System.nanoTime();
            consumer.onMessage(UUID.randomUUID().toString());
            nanos.add(System.nanoTime() - n);
            }
        };

        final Thread t1 = new Thread(r, "t1");
        final Thread t2 = new Thread(r, "t2");
        final Thread t3 = new Thread(r, "t3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.printf("Elapsed time for %s queue: %s%n", name, Duration.ofNanos(nanos.longValue()));
        }

    private static void testDoNothing() throws InterruptedException
        {
        final MsgConsumer msgConsumer = _str -> {
        };

        testOnMessage("do-nothing", msgConsumer);
        }

    private static void testJulLog() throws Exception
        {
        final MsgConsumer msgConsumer = L::info;

        testOnMessage("jul-log", msgConsumer);
        }

    private static void testChronicleQueue() throws InterruptedException
        {
        final SingleChronicleQueue queue = SingleChronicleQueueBuilder.binary("openhft-queue")
            .rollCycle(RollCycles.HOURLY)
            .build();

        final MsgConsumer msgConsumer = queue.acquireAppender().methodWriter(MsgConsumer.class);

        testOnMessage("chronicle-map", msgConsumer);

        queue.close();
        }

    private static void testChronicleMap() throws IOException
        {
        final ChronicleMap<String, String> map = ChronicleMapBuilder.of(String.class, String.class)
            .name("chronicle")
            .entries(100000)
            .averageKey(UUID.randomUUID().toString())
            .averageValueSize(4)
            .createPersistedTo(new File("openhft-map"));

        testConcurrentMap(map);
        }
    }
