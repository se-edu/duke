import java.util.Scanner;

/**
 * Represents the bot Duke.
 * Duke can perform tasks based on user input.
 *
 * {@value #NUM_OF_TASKS} Number of Tasks.
 */
public class Duke {

    public static int NUM_OF_TASKS = 0;

    /**
     * Runs other methods for main.
     *
     * @param args User Input.
     */
    public static void main(String[] args) {
        printGreetings();
        listActions();
    }

    /**
     * Prints greetings.
     */
    public static void printGreetings(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");
    }

    /**
     * Returns actions for lists based on user input.
     */
    public static void listActions() {
        Task[] list = new Task[100];
        Scanner in = new Scanner(System.in);
        String line;

        do {
            line = in.nextLine();
            if (line.contains("done")){
                updateTask(line,list);
            }else if (line.equalsIgnoreCase("bye")){
                printBye();
                break;
            }else if(line.equalsIgnoreCase("list")) {
                printList(list);
            }else{
                list[NUM_OF_TASKS] = addToList(line);
            }
        } while (!line.equalsIgnoreCase("bye"));

    }
    /**
     * Adds new task to the list.
     *
     * @param line User input task name.
     */
    public static Task addToList(String line){
        Task t = new Task(line);
        System.out.println("added " + line);
        NUM_OF_TASKS++;
        return t;
    }

    /**
     * Prints task list.
     *
     * @param list Task list.
     */
    public static void printList(Task[] list) {
        if (NUM_OF_TASKS == 0){
            System.out.println("The list is empty!");
        }else {
            System.out.println("Here are the tasks in your list.");
            for (int i = 0; i < NUM_OF_TASKS; i++) {
            System.out.println(i+1 + ". " + "[" + list[i].getStatusIcon() + "] " + list[i].description);
            }
        }
    }

    /**
     * Marks task as done.
     *
     * @param line User Input.
     * @param list Task list.
     */
    public static void updateTask(String line,Task[] list){
        String taskNumString = line.substring(5);
        int taskNumInt = Integer.parseInt(taskNumString);
        list[taskNumInt-1].markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("["+list[taskNumInt-1].getStatusIcon()+"]"+ list[taskNumInt-1].description);
    }

    /**
     * Prints goodbye.
     */
    public static void printBye(){
        System.out.println("Bye. Hope to see you again soon!");
    }


}

