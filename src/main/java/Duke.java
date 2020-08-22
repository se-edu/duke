import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    public static class Task{
        private String data;
        private boolean isDone;
        private int taskNumber;
        private static int numberOfTasks = 0;

        public Task(String input1, boolean input2){
            data = input1;
            isDone = input2;
            numberOfTasks++;
            taskNumber = numberOfTasks;
        }

        public void setIsDone(boolean input1){
            isDone = input1;
        }

        public boolean getIsDone(){
            return isDone;
        }

        public String getData(){
            return data;
        }

        public void printTask(){
            if(isDone == true){
                System.out.printf("%d.[✓] %s", taskNumber, data);
            }else{
                System.out.printf("%d.[✗] %s", taskNumber, data);
            }
        }
    }

    public static void printMessagae(String message){
        System.out.println("____________________________________________________________");
        if(message.equals("bye")){
            System.out.println(" Bye. Hope to see you again soon!");
        }else{
            System.out.printf(" %s", message);
            System.out.println();
        }

        System.out.println("____________________________________________________________");
    }

    public static void printList(Task[] list, int listLength){
        System.out.println("____________________________________________________________");
        System.out.println(" Here are the tasks in your list");
        for(int i = 0; i < listLength; i++){
            System.out.print(" ");
            list[i].printTask();
            System.out.println();
        }
        System.out.println("____________________________________________________________");
    }

    public static void printDoneStatement(Task taskObject){
        System.out.println("____________________________________________________________");
        System.out.print(" Nice! I've marked this task as done: ");
        System.out.println();
        System.out.printf(" [✓] %s", taskObject.getData());
        System.out.println();
        System.out.println("____________________________________________________________");
    }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Duke");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");

        Task[] listInputs = new Task[100];

        String input = "";
        Scanner in = new Scanner(System.in);

        boolean isRunning = true;
        int listPosition = 0;

        while(isRunning == true){
            input = in.nextLine();
            if(input.equals("bye")) {
                printMessagae(input);
                isRunning = false;
            }else if (input.equals("list")){
                printList(listInputs, listPosition);
            }else if("done".equals(input.substring(0,4))) {
                int taskNumber = Integer.parseInt(input.substring(5, input.length())) - 1;
                if(taskNumber < listPosition && taskNumber >= 0){
                    listInputs[taskNumber].setIsDone(true);
                    printDoneStatement(listInputs[taskNumber]);
                }else{
                    printMessagae("Invalid task number");
                }
            }else{
                printMessagae("added: " + input);
                listInputs[listPosition] = new Task(input, false);
                listPosition++;
            }
        }
    }
}
