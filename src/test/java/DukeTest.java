import java.util.Scanner;

public class DukeTest {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        Scanner scanner = new Scanner(System.in);
        while(!scanner.equals("bye")) {
            System.out.println(scanner);
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}
