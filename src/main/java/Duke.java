import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Duke.printGreeting();
        String input = "";
        while (!(input = sc.nextLine()).equals("bye")) {
            Duke.echo(input);
        }
        Duke.printExit();
    }

    public static void echo(String input) {
        System.out.println(input);
    }

    public static void printGreeting() {
        System.out.println("Hello! I'm Duke\n"
                + "What can I do for you?");
    }

    public static void printExit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void printLogo() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }
}
