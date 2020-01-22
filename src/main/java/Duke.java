
import java.util.ArrayList;
import java.util.Scanner;

/**
 * For level-1 Greet, Echo, Exit.
 */
public class Duke {

    /**
     * Main method.
     * @param args arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Task> mylist = new ArrayList<>();

        System.out.println("Hello! I'm Duke\n"
                + "     What can I do for you?");

        while (true) {
            String response = sc.nextLine();
            String messageType = checkMessageType(response);

            if (messageType.equals("bye")) {
                System.out.println("     ____________________________________________________________");
                System.out.println("     Bye. Hope to see you again soon!");
                System.out.println("     ____________________________________________________________");
                break;

            } else {
                printAction(messageType, mylist, response);
            }

        }

    }


    public static String checkMessageType(String response) {
        if (response.contains("bye")) {
            return "bye";
        }
        if (response.contains("list")) {
            return "list";
        }

        if (response.contains("done")) {
            return "done";
        }

        if (response.contains("todo")) {
            return "todo";
        }

        if (response.contains("deadline")) {
            return "deadline";
        }

        if (response.contains("event")) {
            return "event";
        }

        return response; // does not contain any keyword, return the response.
    }


    public static void printAction(String messageType, ArrayList<Task> mylist, String response) {
        if (messageType.equals("list")){

            printFormatting();
            System.out.println("     Here are the tasks in your list:");
            for (int i = 0; i < mylist.size(); i++) {
                System.out.println("     " + (i + 1) + ". " + mylist.get(i));
            }
            printFormatting();

        } else if (messageType.equals("done")) {

            int taskNumberDone = Integer.parseInt(response.split(" ")[1]);
            Task doneTask = mylist.get(taskNumberDone - 1);
            doneTask.completedTask();
            printFormatting();
            System.out.println("      Nice! I've marked this task as done: ");
            System.out.println("        " + doneTask);
            printFormatting();


        } else if (messageType.equals("todo")) {
            Task newTask = new Todo(response.replace("todo ", ""));
            mylist.add(newTask);
            printFormatting();
            System.out.println("     Got it. I've added this task:");
            System.out.println("       " + newTask);
            System.out.printf("     Now you have %d tasks in the list.\n", mylist.size());
            printFormatting();


        } else if (messageType.equals("deadline")) {

            String deadline = response.split("/")[1];
            String description = response.split("/")[0].replace("deadline ", "");
            Task newTask = new Deadline(description, deadline);
            mylist.add(newTask);
            printFormatting();
            System.out.println("     Got it. I've added this task:");
            System.out.println("       " + newTask);
            System.out.printf("     Now you have %d tasks in the list.\n", mylist.size());
            printFormatting();


        } else if (messageType.equals("event")) {

            String eventTiming = response.split("/")[1];
            String description = response.split("/")[0].replace("event ", "");
            Task newTask = new Event(description, eventTiming);
            mylist.add(newTask);
            printFormatting();
            System.out.println("     Got it. I've added this task:");
            System.out.println("       " + newTask);
            System.out.printf("      Now you have %d tasks in the list.\n", mylist.size());
            printFormatting();

        } else {
            Task newTask = new Task(response);
            mylist.add(newTask);
            printFormatting();
            System.out.println("     added: " + newTask.getDescription());
            printFormatting();
        }

    }

    public static void printFormatting() {
        System.out.println("     ____________________________________________________________");
    }


}
