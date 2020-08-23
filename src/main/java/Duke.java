import java.util.Scanner;

/**
 * main duke chat bot main function
 */
public class Duke {
    static Task[] storedUserTasks = new Task[100];
    static int numberStoredTasks = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        dukeGreet();

        boolean dukeRunning = true;
        String userInput;
        while (dukeRunning){
            userInput = in.nextLine();
            if (userInput.equals("bye")){
                dukeRunning = false;
            }
            else if (userInput.equals("list")){
                dukeReadStoredTasks();
            }
            else if (userInput.substring(0,4).equals("done")){
                int taskNumber = Integer.parseInt(userInput.split(" ")[1]);
                dukeSetDone(taskNumber);
            }
            else {
                dukeEcho(userInput);
                storedUserTasks[numberStoredTasks] = new Task(userInput);
                numberStoredTasks++;
            }
        }
        dukeGoodBye();
    }

    /**
     * prints a horizontal line with the specificed length
     *
     * @param length the length of horizontal line
     */
    public static void printHorizontalLine(int length){
        for (int i = 0; i < length; i++){
            System.out.print("_");
        }
        System.out.print("\n");
    }

    /**
     * prints a greeting to the user
     */
    public static void dukeGreet(){
        printHorizontalLine(50);
        System.out.println("Hello! I'm Duke, not that anybody cares.");
        System.out.println("Make it quick, im busy!");
        System.out.println();
    }

    /**
     * prints a goodbye message to the user
     */
    public static void dukeGoodBye(){
        printHorizontalLine(50);
        System.out.println("Bye. Hope to see you again never!");
        System.out.println("Now get out of my sight!");
        System.out.println();
        printHorizontalLine(50);
    }

    /**
     * repeats whatever the user said
     * @param userInput the user message
     */
    public static void dukeEcho(String userInput){
        printHorizontalLine(50);
        System.out.println("added: " + userInput);
        printHorizontalLine(50);
    }

    /**
     * Ask duke to read out the user's list of tasks it stored
     */
    public static void dukeReadStoredTasks(){
        printHorizontalLine(50);
        for (int i = 0; i < numberStoredTasks; i++){
            System.out.println((i+1) + ". " + storedUserTasks[i]);
        }
        printHorizontalLine(50);
    }

    /**
     * ask duke to set a certain task to be done. duke will complain if you don't provide a valid task number!
     * @param taskNumber the task number of the task in order the task was given to duke e.g. 10th task is 10
     */
    public static void dukeSetDone(int taskNumber){
        if (taskNumber >= numberStoredTasks || taskNumber <= 0){
            System.out.println("Are you stupid? There is no such Task");
            return;
        }
        storedUserTasks[taskNumber-1].done();
        System.out.println("Does the completion of such mundane tasks elicit joy in you?");
        System.out.println("Or does the emptiness that ensues it's completion fill you with regret?");
        System.out.println(storedUserTasks[taskNumber-1]);
    }
}
