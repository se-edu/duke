import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Duke {
    public static final int MAX_STRING_LENGTH = 60;
    public static final int MAX_TASKS = 100;

    private static void print(String message) {
        System.out.println("    ____________________________________________________________");

        for (String str : message.split("\n")) {
            int index = 0;
            while (index < str.length()) {
                String indentation = "      ";
                int print_length = Math.min(str.length() - index, MAX_STRING_LENGTH - 2);

                System.out.println(indentation + str.substring(index, index + print_length));
                index += print_length;
            }
        }
        
        System.out.println("    ____________________________________________________________");
    }
    
    public static void main(String[] args) {
        print("Wussup! I'm Dukeee\nWhat you want me do?");
        boolean is_running = true;

        while (is_running) {
            Scanner scanner = new Scanner(System.in);
            List<String> tasks = new ArrayList<>(MAX_TASKS);
            
            while (is_running && scanner.hasNextLine()) {
                String input = scanner.nextLine();
                switch (input) {
                case "bye":
                    print("Bye! See you never! (((:");
                    is_running = false;
                    break;
                case "list":
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < tasks.size(); i++) {
                        sb.append(String.format("%d. %s\n", i + 1, tasks.get(i)));
                    }
                    print(sb.toString());
                    break;
                default:
                    tasks.add(input);
                    print(String.format("added: %s", input));
                    break;
                }
            }

            scanner.close();
        }
    }
}
