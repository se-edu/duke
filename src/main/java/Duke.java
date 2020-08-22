import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Duke {
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

    public static void printList(String[] list, int listLength){
        System.out.println("____________________________________________________________");
        for(int i = 0; i < listLength; i++){
            System.out.printf("%d. %s\n", i, list[i]);
        }
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

        String[] listInputs = new String[100];

        String input = "";
        Scanner in = new Scanner(System.in);

        boolean isRunning = true;
        int listPosition = 0;

        while(isRunning == true){
            input = in.nextLine();
            switch(input){
            case "bye":
                printMessagae(input);
                isRunning = false;
                break;
            case "list":
                printList(listInputs, listPosition);
                break;
            default:
                printMessagae("added: " + input);
                listInputs[listPosition] = input;
                listPosition++;
                break;
            }
        }
    }
}
