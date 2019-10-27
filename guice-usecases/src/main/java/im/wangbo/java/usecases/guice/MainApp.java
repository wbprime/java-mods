package im.wangbo.java.usecases.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.Scanner;

public class MainApp {
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);

    //      final CommandRouter commandRouter = new CommandRouter();

    final Injector injector = Guice.createInjector(new MainModule());
    final CommandRouter commandRouter = injector.getInstance(CommandRouter.class);

    int n = 0;
    while (scanner.hasNextLine() && n < 3) {
      n++;
      commandRouter.route(scanner.nextLine());
    }
  }
}
