package im.wangbo.java.usecases.dagger;

import im.wangbo.java.usecases.dagger.app.Command.Status;
import im.wangbo.java.usecases.dagger.app.CommandProcessor;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        final MainComponent mainComponent = MainComponent.builder()
            .setMysqlHost("TODO")
            .setMysqlPort(100)
            .setMysqlUsername("sa")
            .setMysqlPassword("sapwd")
            .build();
        final CommandProcessor processor = mainComponent.commandProcessor();

        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            final Status status = processor.process(scanner.nextLine());
            if (status.equals(Status.QUITING)) {
                break;
            }
        }
    }
}
