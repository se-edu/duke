import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // Sample implementation of an exit command.
        while(true) {
            try {
                String userInput = in.readLine();
                if (userInput.trim().equals("exit")) {
                    System.exit(0);
                }
                System.out.println(userInput);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
