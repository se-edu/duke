import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {

    public static void echo(String word) {
        System.out.println(
            "____________________________________________________________\n"
            + "added: " + word + " \n"
            + "____________________________________________________________\n"
        );
    }

    public static void printList(Task[] taskList, int size) {
        System.out.println("____________________________________________________________\n");
        for(int i = 0; i < size; i++) {
            System.out.println((i+1) + ". " + taskList[i].getStatusIcon()
                    + " " + taskList[i].description);
        }
        System.out.println("____________________________________________________________\n");
    }

    public static void printDone(Task doneItem) {
        System.out.println("____________________________________________________________\n"
        + "Nice! I've marked this task as done: \n"
        + doneItem.getStatusIcon()  + " "
        + doneItem.description
        );
        System.out.println("____________________________________________________________\n");
    }

    public static void main(String[] args) {
        String logo = "____________________________________________________________\n"
                + "Hello! I'm Duke\n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";
        String byeSign = "____________________________________________________________\n"
                + "Bye. Hope to see you again soon!\n"
                + "____________________________________________________________\n";

        System.out.println(logo);

        int index = 0;
        String line;
        Task[] taskList = new Task[100];
        Scanner in = new Scanner(System.in);
        line = in.nextLine();

        while (!line.equals("bye")) {
            if(line.equals("list")){
                printList(taskList, index);
            }
            else if(line.contains("done")) {
                int number = Integer.parseInt(line.replaceAll("[^0-9]", ""));
                taskList[number-1].markAsDone();
                printDone(taskList[number-1]);
            }
            else {
                //add item to list
                taskList[index] = new Task(line);
                echo(line);
                index++;
            }

            in = new Scanner(System.in);
            line = in.nextLine();
        }

        System.out.println(byeSign);
    }
}
