import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {

    public static void echo(String word) {
        System.out.println(
            "____________________________________________________________\n"
            + "added: " + word + " \n"
            + "____________________________________________________________\n"
        );
    }

    private static void printList(List<String> botList) {
        System.out.println("____________________________________________________________\n");
        for(int i = 0; i < botList.size(); i++) {
            System.out.println((i+1) + ". " + botList.get(i));
        }
        System.out.println("____________________________________________________________\n");
    }

    public static void main(String[] args) {
        String logo = "____________________________________________________________\n"
                + "Hello! I'm Duke\n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";
        String byeSign = "____________________________________________________________\n"
                + "Bye. Hope to see you again soon!\n"
                + "____________________________________________________________\n";

        System.out.println(logo);

        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();

        List<String> botList = new ArrayList<>();

        while (!line.equals("bye")) {
            if(line.equals("list")){
                printList(botList);
            }
            else {
                //add item to list
                botList.add(line);
                echo(line);
            }
            in = new Scanner(System.in);
            line = in.nextLine();
        }

        System.out.println(byeSign);
    }
}
