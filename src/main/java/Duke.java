import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static final String horizontalLine = "____________________________________________________________";
    private static ArrayList<String> taskArrayList = new ArrayList<String>();

    public static void printWithIndentation(String string) {
        System.out.println("\t" + string);
    }

    public static void addToTaskArrayList(String description) {
        taskArrayList.add(description);
        printWithIndentation(horizontalLine);
        printWithIndentation("added: " + description);
        printWithIndentation(horizontalLine);
    }

    public static void printTaskArrayList() {
        printWithIndentation(horizontalLine);
        for (int i = 0; i < taskArrayList.size(); i++) {
            printWithIndentation((i + 1) + ". " + taskArrayList.get(i));
        }
        printWithIndentation(horizontalLine);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        printWithIndentation(horizontalLine);
        printWithIndentation("Hello! I'm Duke");
        printWithIndentation("What can I do for you?");
        printWithIndentation(horizontalLine);

        String input = sc.nextLine();

        while (true) {
            if (input.equals("bye")) {
                break;
            } else if (input.equals("list")) {
                printTaskArrayList();
            } else {
                addToTaskArrayList(input);
            }

            input = sc.nextLine();
        }

        printWithIndentation(horizontalLine);
        printWithIndentation("Bye. Hope to see you again soon!");
        printWithIndentation(horizontalLine);
    }
}
