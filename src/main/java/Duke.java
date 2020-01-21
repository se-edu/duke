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
                System.out.println("Cya next time!");
                break;
            } else if (input.equals("list")) {
                int num = lst.size();
                for (int i = 0; i < num; i++) {
                    System.out.println((i + 1) + ". " + lst.get(i));
                }
            } else if (input.contains ("done")) {
                //Mark task as done with keyword "done" followed by task number
                try {
                    int taskNum = Integer.parseInt(input.substring(5));
                    if (taskNum <= lst.size()) {
                        Task completedTask = lst.get(taskNum - 1);
                        if (completedTask.getStatus().equals("Done")) {
                            System.out.println ("You have already completed this task!");
                        } else {
                            completedTask.markAsDone();
                            pendingTask--;
                        }
                        if (pendingTask == 0) {
                            System.out.println ("Yay! You have no more task remaining!");
                        } else {
                            System.out.println ("You have " + pendingTask + " tasks remaining!");
                        }
                    } else {
                        System.out.println ("Sorry, there is no such task!");
                    }
                } catch (Exception e){
                    System.out.println ("Sorry, I dont understand you request!");
                }
            } else if (input.contains ("delete")) {
                try {
                    int taskNum = Integer.parseInt(input.substring(7));
                    if (taskNum <= lst.size()) {
                        Task deletedTask = lst.get(taskNum - 1);
                        String status = deletedTask.getStatus();
                        if (status.equals ("Not Done")) {
                            //Pending task count drops only if deleted task not completed
                            pendingTask--;
                        }
                        System.out.println ("Noted. I've removed this task:\n" + deletedTask
                                + "\nNow you have " + pendingTask + " tasks in the list.");
                        lst.remove (taskNum -1);
                    }
                } catch (Exception e) {
                    System.out.println ("Sorry, there is no such task!");
                }
            } else {
                //Create task using key words: "todo", "deadline", "event"
                if (input.contains ("todo")) {
                    //todo request format: todo<space><task>
                    try {
                        String task1 = input.substring(5);
                        if (task1.isEmpty()) {
                            System.out.println ("OOOPS!! Cannot have empty todo request!!!");
                        } else {
                            Todo todo = new Todo(task1);
                            lst.add(todo);
                            pendingTask++;
                            System.out.println("Got it. I've added the following task:\n" +
                                    todo + "\nYou now have " + pendingTask + " task in the list");
                        }
                    } catch (Exception e) {
                        System.out.println ("Huh? I do not understand this todo request:/");
                    }
                } else if (input.contains ("deadline")) {
                    //deadline request format: deadline<space><task><space></><by when>"
                    try {
                        int taskIndex = input.indexOf("/");
                        int byIndex = taskIndex + 4;
                        Deadline deadline = new Deadline(input.substring(9, taskIndex),
                                input.substring(byIndex));
                        lst.add(deadline);
                        pendingTask++;
                        System.out.println("Got it. I've added the following task:\n" +
                                deadline + "\nYou now have " + pendingTask + " task in the list");
                    } catch (Exception e) {
                        System.out.println ("Huh? This deadline request does not make sense");
                    }
                } else if (input.contains ("event")) {
                    //event request format: event<space><task><space></><at when>
                    try {
                        int taskIndex = input.indexOf("/");
                        int atIndex = taskIndex + 4;
                        Event event = new Event(input.substring(6, taskIndex),
                                input.substring(atIndex));
                        lst.add(event);
                        pendingTask++;
                        System.out.println("Got it. I've added the following task:\n" +
                                event + "\nYou now have " + pendingTask + " task in the list");
                    } catch (Exception e) {
                        System.out.println ("What? What event is this??");
                    }
                } else {
                    //must have todo/deadline/event request format
                    System.out.println ("Im sorry, but I do not understand what this means:-(");
                }
            }
        }
    }
}