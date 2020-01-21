import java.util.*;

public class Duke {

    public static final String LINE = "____________________________________________________________";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        firstGreeting();

        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                System.exit(0);
            }
            System.out.println(input);
        }
    }

    public static void firstGreeting(){
        String firstGreet = LINE
                + "\n Hello! I'm Duke \n"
                + " What can I do for you? \n"
                + LINE;
        System.out.println(firstGreet);
    }

    public static void directAnswering(String input){
        String directAnswer = LINE + "\n" + " " + input + "\n" + LINE;
        System.out.println(directAnswer);
    }
}
