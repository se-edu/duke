import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static int counter = 0;

    public static void main(String[] args) {
        ArrayList<Task> tasklist = new ArrayList<>();
        System.out.println("Hey, I'm Duke");
        System.out.println("What's up");

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String nextString = scanner.nextLine();
            if (nextString.equals("bye")) {
                System.out.println("Bye.");
            } else if (nextString.equals("list")){
                System.out.println("Here are the tasks in your list: ");
                for (Task t: tasklist) {
                    System.out.println((tasklist.indexOf(t) + 1) + ". [" + t.getStatusIcon() + "] " + t.description);
                }
            } else if (nextString.contains("done")){
                String[] temp = nextString.split(" ");
                int index = Integer.parseInt(temp[1]) - 1;
                System.out.println("Nice! I've marked this task as done: ");
                Task current = tasklist.get(index);
                current.isDone = true;
                System.out.println("[" + current.getStatusIcon() + "] " + current.description);
            } else {
                Task t = new Task(nextString);
                tasklist.add(counter, t);
                System.out.println("added: " + nextString);
                counter++;
            }
        }
    }
}
