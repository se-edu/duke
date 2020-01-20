import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        String line = "__________________________";
        ArrayList <Task> lst = new ArrayList <>();
        int pendingTask = 0;
        System.out.println(line + "\nWhat can i do for you?\n" + line);

        while (true) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                //Leaves Duke
                System.out.println ("Cya next time!");
                break;
            } else if (input.equals ("list")) {
                //Open up list of Task
                System.out.println ("Here are the tasks in your list: ");
                int num = lst.size();
                for (int i = 1; i <= num; i++) {
                    Task task = lst.get(i - 1);
                    System.out.println(i + ". " + task);
                }
            } else if (input.contains ("done")) {
                //Mark task as done
                try {
                    int taskNum = (sc.nextInt()) - 1;
                    sc.nextLine();
                    if (taskNum > lst.size()) {
                        //If user inputs invalid task number
                        System.out.println("No such task!\n");
                    } else {
                        //User marks undone task as done
                        Task completedTask = lst.get(taskNum);
                        if (!completedTask.isItDone()) {
                            completedTask.markAsDone();
                            pendingTask--;
                        } else {
                            //Indicating a task that has already been done
                            System.out.println ("This task has already been done!");
                        }
                        if (pendingTask == 0) {
                            //Indicate to user there are no more pending task
                            System.out.println("0 task remaining! You are free:)\n");
                        } else {
                            System.out.println ("You have " + pendingTask + " task remaining!");
                        }
                    }
                } catch (Exception e){
                    //In the case user inputs a non-int data type
                    sc.nextLine();
                    System.out.println ("Please type in a task number:(");
                }
            } else {
                //User adding a new task
                switch (input.toLowerCase()) {
                    case "todo":
                        System.out.println("Okay! Whats your todo task?");
                        Todo task1 = new Todo (sc.nextLine());
                        lst.add(task1);
                        pendingTask++;
                        System.out.println ("Got it! I'm adding this to your list:\n" + task1);
                        System.out.println ("Now you have " + pendingTask + " task remaining.");
                        break;
                    case "deadline":
                        System.out.println("Okay! What is your deadline task?");
                        String deadlineTask = sc.nextLine();
                        System.out.println("Alright. When is the deadline?");
                        Deadline task2 = new Deadline (deadlineTask, sc.nextLine());
                        lst.add(task2);
                        pendingTask++;
                        System.out.println ("Got it! I'm adding this to your list:\n" + task2);
                        System.out.println ("Now you have " + pendingTask + " task in your list.");
                        break;
                    case "event":
                        System.out.println("Okay! What event is coming up?");
                        String event = sc.nextLine();
                        System.out.println ("Alright! What time is the event?");
                        String eventTime = sc.nextLine();
                        Event task3 = new Event (event, eventTime);
                        lst.add(task3);
                        pendingTask++;
                        System.out.println ("Got it! I'm adding this to your list:\n " + task3);
                        System.out.println ("Now you have " + pendingTask + " task remaining.");
                        break;
                    default:
                        System.out.println ("Invalid Command");
                }
            }
        }
    }
}
