import java.util.Scanner;

public class Duke {
    public static void printWithIndentation(String string) {
        System.out.println("\t" + string);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String horizontalLine = "____________________________________________________________";

        printWithIndentation(horizontalLine);
        printWithIndentation("Hello! I'm Duke");
        printWithIndentation("What can I do for you?");
        printWithIndentation(horizontalLine);

        String input = sc.nextLine();

        while (!input.equals("bye")) {
            printWithIndentation(horizontalLine);
            printWithIndentation(input);
            printWithIndentation(horizontalLine);

            input = sc.nextLine();
        }

        printWithIndentation(horizontalLine);
        printWithIndentation("Bye. Hope to see you again soon!");
        printWithIndentation(horizontalLine);
    }
}
