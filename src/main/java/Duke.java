import java.util.Scanner;

public class Duke {

    public static void echo(String word) {
        System.out.println(
            "____________________________________________________________\n"
            + word + " \n"
            + "____________________________________________________________\n"
        );
    }

    public static void main(String[] args) {
        String logo = "____________________________________________________________\n"
                + "Hello! I'm Duke\n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";
        String byeSign = "____________________________________________________________\n"
                + "Bye. Hope to see you again soon!\n"
                + "____________________________________________________________\n";
        String[] list = new String[100];
        int i = 0;

        System.out.println(logo);

        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();

        while (!line.equals("bye")) {
            echo(line);
            in = new Scanner(System.in);
            line = in.nextLine();
        }

        if (line.equals("bye")) {
            System.out.println(byeSign);
        }
    }
}
