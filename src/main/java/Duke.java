import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        boolean exit = false;
        String line;
        Scanner in = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        greet();
        while(!exit) {
            line = in.nextLine();
            //System.out.println(line);
            if(line.equals("list")) {
                list();
            }
            else if(line.equals("bye")) {
                exit = true;
            }
            else {
                echo(line);
            }
        }
        exit();
    }

    public static void greet() {
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    public static void echo(String message) {
        System.out.println("____________________________________________________________");
        System.out.println(message);
        System.out.println("____________________________________________________________");}

    public static void exit() {
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }

    public static void list() {
        System.out.println("____________________________________________________________");
        System.out.println("list");
        System.out.println("____________________________________________________________");}
}
