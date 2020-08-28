import java.util.Scanner;

public class Duke {

    public static int NUM_OF_TASKS = 0;

    public static void main(String[] args) {
        Greetings();
        ListActions();
    }
    public static void Greetings(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");
    }
    
    public static void ListActions() {
        Task[] List = new Task[100];
        Scanner in = new Scanner(System.in);
        String line;

        do {
            line = in.nextLine();
            if (line.contains("done")){
                UpdateTask(line,List);
            }else if (line.equalsIgnoreCase("bye")){
                PrintBye();
                break;
            }else if(line.equalsIgnoreCase("list")) {
                PrintList(List);
            }else{
                List[NUM_OF_TASKS] = AddToList(line);
            }
        } while (!line.equalsIgnoreCase("bye"));

    }

    public static Task AddToList(String line){
        Task t = new Task(line);
        System.out.println("added " + line);
        NUM_OF_TASKS++;
        return t;
    }

    public static void PrintList(Task[] List) {
        if (NUM_OF_TASKS == 0){
            System.out.println("The list is empty!");
        }else {
            System.out.println("Here are the tasks in your list.");
            for (int i = 0; i < NUM_OF_TASKS; i++) {
            System.out.println(i+1 + ". " + "[" + List[i].getStatusIcon() + "] " + List[i].description);
            }
        }
    }

    public static void UpdateTask(String line,Task[] List){
        String taskNumString = line.substring(5);
        int taskNumInt = Integer.parseInt(taskNumString);
        List[taskNumInt-1].markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("["+List[taskNumInt-1].getStatusIcon()+"]"+ List[taskNumInt-1].description);
    }

    public static void PrintBye(){
        System.out.println("Bye. Hope to see you again soon!");
    }


}

