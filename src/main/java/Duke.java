import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("___________________________________________________________________________");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");


        Scanner scanner = new Scanner(System.in);
        String line;




            System.out.println("___________________________________________________________________________");
            line = scanner.nextLine();
            System.out.println(line + "\n");
            System.out.println("___________________________________________________________________________");
        while (!line.toUpperCase().equals("BYE")) {
            line = scanner.nextLine();
            System.out.println(line + "\n");
            System.out.println("___________________________________________________________________________");

        }




        System.out.println("Bye. Hope to see you again soon!\n");

        System.out.println("___________________________________________________________________________");


    }
}