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

        String input = "";
        Scanner in = new Scanner(System.in);

        while(true){
            input = in.nextLine();
            printMessagae(input);
            if(input.equals("bye")){
                break;
            }
        }
    }
}
