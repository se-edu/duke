import java.util.*;
import task.Task;

/**
 * main class of Duke program
 * controlling the main logic
 */
public class Duke {

    public static final String LINE = "____________________________________________________________";
    public static String markAsDone = "Nice! I've marked this task as done:";
    public static String showList = "Here are the tasks in your list:";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        greet();

        ArrayList<Task> list = new ArrayList<>();

        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                exit();
            } else if (input.length() > 4 && input.substring(0,4).equals("done")) {
                int thisIndex = Integer.valueOf(input.substring(5)) - 1;
                System.out.println(LINE);
                if(thisIndex >= list.size() || thisIndex < 0){
                    continue;
                } else {
                    System.out.println(markAsDone);
                    list.get(thisIndex).markAsDone();
                    System.out.println(list.get(thisIndex).toString());
                    System.out.println(LINE + "\n");
                }
            } else if (input.equalsIgnoreCase("list")) {
                displayList(list);
            } else {
                Task thisTask = new Task(input);
                addItem(list, thisTask);
                echo(input);
            }
        }
    }

    /**
     * This method greet the users at the beginning of the conversation.
     */
    public static void greet(){
        String firstGreet = LINE
                + "\n Hello! I'm Duke \n"
                + " What can I do for you? \n"
                + LINE;
        System.out.println(firstGreet + "\n");
    }

    /**
     * This method says goodbye to the user and quit the system.
     */
    public static void exit(){
        String directAnswer = LINE + "\n" + " Bye. Hope to see you again soon!" + "\n" + LINE;
        System.out.println(directAnswer + "\n");
        System.exit(0);
    }

    /**
     * This method echos whatever the user inputs.
     */
    public static void echo(String input){
        String directAnswer = LINE + "\n" + " added: " + input + "\n" + LINE;
        System.out.println(directAnswer + "\n");
    }

    /**
     * @param list
     * @param thisTask
     * This method add a new task object to the array list.
     */
    public static void addItem(ArrayList<Task> list, Task thisTask){
        list.add(thisTask);
    }

    /**
     * @param list
     * This method displays the list of tasks.
     */
    public static void displayList(ArrayList<Task> list){
        System.out.println(LINE);
        System.out.println(showList);
        int marker = 1;
        if(list.isEmpty()){
            System.out.println(LINE + "\n");
        } else {
            System.out.println(LINE);
            for(int i = 0; i < list.size(); i++){
                System.out.println(" " + (i + 1) + ". " + list.get(i).toString());
            }
            System.out.println(LINE + "\n");
        }
    }
}
