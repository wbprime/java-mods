package im.wangbo.java.usecases.dagger;

import im.wangbo.java.usecases.dagger.app.Command.Status;
import im.wangbo.java.usecases.dagger.app.CommandProcessor;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final CommandProcessor processor = MainComponent.of().commandProcessor();

        while (scanner.hasNextLine()) {
            final Status status = processor.process(scanner.nextLine());
            if (status.equals(Status.QUITING)) {
                break;
            }
        }
    }
}
