import java.util.Scanner;

public class Main {

//    public void echo(String line) {
//        System.out.println("____________________________________________________________");
//        System.out.println(line);
//        System.out.println("____________________________________________________________");
//    }


    public static void main(String[] args) {
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        Scanner in = new Scanner(System.in);
        String[] items = new String[100];
        String line;
        int numItem = 0;
        while (true) {
            line = in.nextLine();
            if (line.equals("bye")) {
                break;
            } else if (line.equals("list")) {
                int numPrintedItems = 0;
                System.out.println("____________________________________________________________");
                for (String item : items) {
                    if (item == null) {
                        break;
                    }
                    numPrintedItems++;
                    System.out.println(numPrintedItems + ". " + item);

                }
                System.out.println("____________________________________________________________");
            } else {
                System.out.println("added: " + line);
                items[numItem] = line;
                numItem++;
            }
        }
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
