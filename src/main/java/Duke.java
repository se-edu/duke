import java.util.Scanner;

public class Duke {
    public static final int MAX_STRING_LENGTH = 60;

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
            
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.equals("bye")) {
                    print("Bye! See you never! (((:");
                    is_running = false;
                    break;
                } else {
                    print(input);
                }
            }

            scanner.close();
        }
    }
}
