package im.wangbo.java.usecases.dagger;

import im.wangbo.java.usecases.dagger.app.Command.Status;
import im.wangbo.java.usecases.dagger.app.CommandParser;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final CommandParser parser = MainComponent.of().parser();

        while (scanner.hasNextLine()) {
            final Status status = parser.process(scanner.nextLine());
            if (status.equals(Status.QUITING)) {
                break;
            }
        }
    }
}
