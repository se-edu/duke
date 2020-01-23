import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke!");
        System.out.println("What can I do for you?");

        Scanner sc = new Scanner(System.in);

        String[] list = new String[100];
        int listCount = 0;

        while (true) {
            String userInput = sc.nextLine();

            if (userInput.equals("bye")) {
                System.out.println("Bye! Come back soon!");
                break;
            } else if (userInput.equals("list")) {
                for (int i = 0; i < listCount; i++) {
                    System.out.println((i+1) + ". " + list[i]);
                }
            } else {
                System.out.println("added: " + userInput);
                list[listCount] = userInput;
                listCount++;
            }
        }
    }
}
