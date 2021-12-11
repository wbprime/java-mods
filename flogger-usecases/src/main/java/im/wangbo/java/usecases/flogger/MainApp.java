package im.wangbo.java.usecases.flogger;

import com.google.common.base.Stopwatch;
import com.google.common.flogger.FluentLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class MainApp {
  private static final FluentLogger F = FluentLogger.forEnclosingClass();
  private static final Logger L = LogManager.getLogger();

  public static void main(String[] args) {
    final int[] arr = {1000, 10000, 100_000, 1_000_000, 100_000_000};
    final Stopwatch stopwatch = Stopwatch.createUnstarted();
    for (final int n : arr) {
      {
        stopwatch.start();
        testFloggerInfo(n);
        final Duration d = stopwatch.stop().elapsed();
        System.out.println("Flogger " + n + ": " + d);
      }
      {
        stopwatch.start();
        testLog4j2Info(n);
        final Duration d = stopwatch.stop().elapsed();
        System.out.println("Log4j2 " + n + ": " + d);
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
      L.atInfo().log("Out FLOGGER: {}", i);
    }
  }
}
