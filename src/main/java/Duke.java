import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n\t"
                + "|  _ \\ _   _| | _____ \n\t"
                + "| | | | | | | |/ / _ \\\n\t"
                + "| |_| | |_| |   <  __/\n\t"
                + "|____/ \\__,_|_|\\_\\___|\n\t";

        //Greeting
        System.out.println("\t____________________________________________________________");
        System.out.println("\tHello from\n\t" + logo);
        System.out.println("\tWhat can I do for you?");
        System.out.println("\t____________________________________________________________");

        Scanner in = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<Task>(100);

        //accepting input
        String input = in.nextLine();

            while (!input.equalsIgnoreCase("Bye")) {
                try {
                    System.out.println("\t____________________________________________________________");
                    //checking input and giving appropriate responses
                    if (input.equalsIgnoreCase("list")) {
                        int size = tasks.size();
                        System.out.println("\tHere are the tasks in your list:");
                        for (int i = 0; i < size; ++i) {
                            System.out.println("\t" + (i + 1) + ". " + tasks.get(i));
                        }
                    } else if (input.startsWith("done")) {
                        String[] tempArray = input.split(" ");
                        int n = Integer.parseInt(tempArray[1]);
                        if (n > tasks.size()) {
                            System.out.println("\tThere is no such task");
                        } else {
                            System.out.println("\tNice! I've marked this task as done:");
                            tasks.get(n - 1).markAsDone();
                            System.out.println("\t" + tasks.get(n - 1));
                        }
                    } else if (input.startsWith("delete")) {
                        String[] tempArray = input.split(" ");
                        int n = Integer.parseInt(tempArray[1]);
                        if (n > tasks.size()) {
                            System.out.println("\tThere is no such task");
                        } else {
                            System.out.println("\tNoted. I have removed this task:");
                            System.out.println("\t" + tasks.get(n - 1));
                            tasks.remove(n-1);
                            System.out.println("\tYou now have " + tasks.size() + " tasks in the list.");
                        }
                    } else {

                        Task temp;
                        String[] splitInput = input.split(" ", 2);
                        if (input.startsWith("todo")) {
                            if (splitInput.length < 2) {
                                throw new EmptyTaskException("todo");
                            }
                            temp = new ToDo(splitInput[1]);
                            tasks.add(temp);
                        } else if (input.startsWith("deadline")) {
                            if (splitInput.length < 2) {
                                throw new EmptyTaskException("deadline");
                            }
                            temp = new Deadline((splitInput[1]).split("/", 2));
                            tasks.add(temp);
                        } else if (input.startsWith("event")) {
                            if (splitInput.length < 2) {
                                throw new EmptyTaskException("event");
                            }
                            temp = new Event((splitInput[1]).split("/", 2));
                            tasks.add(temp);
                        } else {
                            throw new InvalidRequestException();
                        }
                        System.out.println("\tGot it. I've added this task:");
                        System.out.println("\t" + temp);
                        System.out.println("\tNow you have " + tasks.size() + " tasks in your list.");
                    }
                    System.out.println("\t____________________________________________________________");

                    input = in.nextLine();


                } catch (InvalidRequestException e1) {
                    System.out.println("\t" + e1.toString());
                    System.out.println("\t____________________________________________________________");
                    input = in.nextLine();
                } catch (EmptyTaskException e2) {
                    System.out.println("\t" + e2.toString());
                    System.out.println("\t____________________________________________________________");
                    input = in.nextLine();
                }
            }

        //Exit
        System.out.println("\t____________________________________________________________");
        System.out.println("\tBye. Hope to see you again soon!");
        System.out.println("\t____________________________________________________________");

    }
}
