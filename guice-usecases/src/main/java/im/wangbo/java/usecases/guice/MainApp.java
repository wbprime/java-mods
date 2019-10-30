package im.wangbo.java.usecases.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import im.wangbo.java.usecases.guice.app.Command.Status;
import im.wangbo.java.usecases.guice.app.CommandProcessor;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        final Injector injector = Guice.createInjector(new MainModule(
            "TODO", 1993, "TODO", "TODO"
        ));
        final CommandProcessor processor = injector.getInstance(CommandProcessor.class);

        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            final Status status = processor.process(scanner.nextLine());
            if (status.equals(Status.QUITING)) {
                break;
            }
        }
    }
}
