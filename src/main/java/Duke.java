import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hey, I'm Duke");
        System.out.println("What's up");

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String nextString = scanner.nextLine();
            if(nextString.equals("bye")) {
                System.out.println("Bye.");
            } else {
                System.out.println(nextString);
            }
        }
    }
}
