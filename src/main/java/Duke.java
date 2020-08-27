import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n"
                + "____________________________________________________________\n"
                + "Hello! I'm Duke\n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";
        System.out.println("Hello from\n" + logo);
        getInput();
    }
    public static void getInput() {
        Scanner in = new Scanner(System.in);
        String byeMessage = ""
                + "____________________________________________________________\n"
                + "Bye. Hope to see you again soon!\n"
                + "____________________________________________________________\n";
        String input = in.nextLine();
        while((!input.equals("bye")) && (!input.equals("Bye"))){
            System.out.println(""
                + "____________________________________________________________\n"
                + input
                + "\n"
                + "____________________________________________________________\n"
            );
            input = in.nextLine();
        }
        System.out.println(byeMessage);
    }
}
