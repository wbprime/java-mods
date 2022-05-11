package im.wangbo.java.usecases.flogger;

import com.google.common.base.Stopwatch;
import com.google.common.flogger.FluentLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.UUID;

public class MainApp {
  private static final FluentLogger F = FluentLogger.forEnclosingClass();
  private static final Logger L = LogManager.getLogger();

  public static void main(String[] args) {
    final var k = "java.util.logging.manager";
    final var v = System.getProperty(k);
    F.atInfo().log("%s => %s", k, v);

    boolean compareInt = false;
    boolean compareString = false;
    boolean compareObject = true;
    if (true) {
      final int[] arr = {1000, 10000, 100_000, 1_000_000, 10_000_000};
      final Stopwatch stopwatch = Stopwatch.createUnstarted();
      for (final int n : arr) {
        if (compareInt) {
          stopwatch.start();
          testLog4j2Info(n);
          final Duration d = stopwatch.stop().elapsed();
          System.out.println("Log4j2 with single int " + n + ": " + d);
        }
        if (compareInt) {
          stopwatch.start();
          testFloggerInfo(n);
          final Duration d = stopwatch.stop().elapsed();
          System.out.println("Flogger with single int " + n + ": " + d);
        }
        if (compareString) {
          stopwatch.start();
          testFloggerInfoWithStrings(n);
          final Duration d = stopwatch.stop().elapsed();
          System.out.println("Flogger with single string " + n + ": " + d);
        }
        if (compareString) {
          stopwatch.start();
          testLog4j2InfoWithStrings(n);
          final Duration d = stopwatch.stop().elapsed();
          System.out.println("Log4j2 with single string " + n + ": " + d);
        }
        if (compareObject) {
          final var order =
              new Order(
                  UUID.randomUUID().toString(),
                  100,
                  1000.01,
                  OffsetDateTime.now(),
                  "CANCELED",
                  BigDecimal.valueOf(999.7),
                  100,
                  BigDecimal.ZERO,
                  0);
          {
            stopwatch.start();
            testFloggerInfoWithObject(n, order);
            final Duration d = stopwatch.stop().elapsed();
            System.out.println("Flogger with single object " + n + ": " + d);
          }
          {
            stopwatch.start();
            testLog4j2InfoWithObject(n, order);
            final Duration d = stopwatch.stop().elapsed();
            System.out.println("Log4j2 with single object " + n + ": " + d);
          }
        }
      }
    }
  }

  private static void testFloggerInfo(int n) {
    for (int i = 0; i < n; i++) {
      F.atInfo().log("Out FLOGGER: %d", i);
    }
  }

  private static void testLog4j2Info(int n) {
    for (int i = 0; i < n; i++) {
      L.atInfo().log("Out Log4j2: {}", i);
    }
  }

  private static void testFloggerInfoWithStrings(int n) {
    for (int i = 0; i < n; i++) {
      F.atInfo().log("Out FLOGGER: %s", UUID.randomUUID());
    }
  }

  private static void testLog4j2InfoWithStrings(int n) {
    for (int i = 0; i < n; i++) {
      L.atInfo().log("Out Log4j2: {}", UUID.randomUUID());
    }
  }

  private static void testFloggerInfoWithObject(int n, Order o) {
    for (int i = 0; i < n; i++) {
      F.atInfo().log("Out FLOGGER: %d, %s", i, o);
    }
  }

  private static void testLog4j2InfoWithObject(int n, Order o) {
    for (int i = 0; i < n; i++) {
      L.atInfo().log("Out Log4j2: {}, {}", i, o);
    }
  }

  record Order(
      String orderId,
      int qty,
      double price,
      OffsetDateTime createdAt,
      String status,
      BigDecimal filledPrice,
      int filledQty,
      BigDecimal canceledPrice,
      int canceledQty) {}
}
