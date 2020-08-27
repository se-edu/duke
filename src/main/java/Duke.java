import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");
        Echo();

    }

    public static void Echo() {
        Scanner in = new Scanner(System.in);
        while (true){
        String line = in.nextLine();
        if (line.contains("bye") || line.equalsIgnoreCase("bye")) {
            Bye();
            break;
        }else {
            System.out.println(line);
        }
        }

    }
    public static void Bye(){
        System.out.println("Bye. Hope to see you again soon!");
    }
}
