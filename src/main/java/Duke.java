import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static int counter = 0;

    public static void main(String[] args) {
        ArrayList<String> tasklist = new ArrayList<>();
        System.out.println("Hey, I'm Duke");
        System.out.println("What's up");

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String nextString = scanner.nextLine();
            if (nextString.equals("bye")) {
                System.out.println("Bye.");
            } else if (nextString.equals("list")){
                for (String s: tasklist) {
                    System.out.println((tasklist.indexOf(s) + 1) + ". " + s);
                }
            } else {
                tasklist.add(counter, nextString);
                System.out.println("added: " + nextString);
                counter++;
            }
        }
    }
}
