package im.wangbo.java.usecases.dagger;

import im.wangbo.java.usecases.dagger.app.Command.Status;
import im.wangbo.java.usecases.dagger.app.CommandProcessor;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        final MainComponent mainComponent = MainComponent.builder()
            .setJdbcUrl("jdbc:h2:mem:test")
            .setJdbcUsername("h2")
            .setJdbcPassword("user@H2")
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
