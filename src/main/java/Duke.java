import java.util.Scanner;

public class Duke {
    static Scanner scanner = new Scanner(System.in);
    static int taskListIndex = 0;
    static Task taskList[] = new Task[100];

    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("---------------------------------------");

        boolean isRunning = true;
        while(isRunning){
            String input = scanner.nextLine();

            if  (input.equals("bye")) {
                isRunning = false;
            } else if (input.equals("list")){
                listTaskList();
            } else if (input.matches("done.*")) {
                input = input.substring(5); // removes the "done " part of the string
                Task task = finishTask(input);
                if (task != null){
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.print("\t");
                    printTaskStatus(task);
                    System.out.println("---------------------------------------");
                }
            } else {
                addInput(input);
            }
        }

        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("---------------------------------------");
    }

    public static void listTaskList(){
        int i = 1;
        for (Task task : taskList){
            if (task == null) {
                if (i == 1){
                    System.out.println("---------------------------------------");
                }
                break;
            }
            else {
                System.out.print(String.valueOf(i) + ".");
                printTaskStatus(task);
                i++;
            }
        }
        System.out.println("---------------------------------------");
    }

    public static void printTaskStatus(Task task){
        System.out.println("[" + task.getStatusIcon() +"]" +
                " " + task.description);
    }

    public static Task finishTask(String taskName){
        for (Task task : taskList){
            if (task != null && task.description.equals(taskName)) {
                task.isDone = true;
                return task;
            }
        }

        return null;
    }

    public static String addInput(String input){
        System.out.println("added: " + input);
        System.out.println("---------------------------------------");

        Task newTask =  new Task(input);
        taskList[taskListIndex] = newTask;
        taskListIndex++;

        return input;
    }
}
