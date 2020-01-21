
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

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
            if (response.equals("bye")) {
                System.out.println("     ____________________________________________________________");
                System.out.println("     Bye. Hope to see you again soon!");
                System.out.println("     ____________________________________________________________");
                break;

            } else if (response.equals("list")){

                System.out.println("     ____________________________________________________________");
                System.out.println("     Here are the tasks in your list:");
                for (int i = 0; i < mylist.size(); i++) {
                    System.out.println("     " + (i + 1) + ". " + mylist.get(i));
                }
                System.out.println("     ____________________________________________________________");

            } else if (response.contains("done")) {

                int taskNumberDone = Integer.parseInt(response.split(" ")[1]);
                Task doneTask = mylist.get(taskNumberDone - 1);
                doneTask.completedTask();
                System.out.println("     ____________________________________________________________");
                System.out.println("      Nice! I've marked this task as done: ");
                System.out.println("        " + doneTask);
                System.out.println("     ____________________________________________________________");


            } else {
                Task newTask = new Task(response);
                mylist.add(newTask);
                System.out.println("     ____________________________________________________________");
                System.out.println("     added: " + newTask.getDescription());
                System.out.println("     ____________________________________________________________");
            }
        }

    }
}
