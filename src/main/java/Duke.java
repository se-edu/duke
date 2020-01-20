import java.util.Scanner;
import java.util.Arrays;

public class Duke {
    private static Task[] mainList;
    private static int maxLength;

    public static void main(String[] args) {
        mainList = new Task[100];
        maxLength = 60;
        int currIndex = 0;
        String logo = " _________                        \n" +
                " __  ____/_______________________ \n" +
                " _  / __ _  __ \\  __ \\_  ___/  _ \\  >(o )___\n" +
                " / /_/ / / /_/ / /_/ /(__  )/  __/   ( ._> /\n" +
                " \\____/  \\____/\\____//____/ \\___/     `---'";

        System.out.println("Hello it's\n" + logo);

        String greeting = "Honk, this Goose. Do you need help with something?";
        System.out.println("\n" + wrapLine(greeting));

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArr;

        while (!input.equalsIgnoreCase("bye")) {
            inputArr = input.split(" ");

            if (input.equals("list")) {
                // print list
                System.out.println(wrapLine("Honk! Here's your task list: \n" + printList()));
                input = scanner.nextLine();

            } else if (inputArr[0].equals("done")) {
                // extract list number of task to be marked as done
                int taskIndex = Integer.parseInt(inputArr[1]);
                Task selected = mainList[taskIndex - 1];
                selected.markAsDone();

                String reply = "Good job! I've honked it as done:\n";
                System.out.println(wrapLine(reply + "           " + selected));
                input = scanner.nextLine();

            } else if (inputArr[0].equals("event") || inputArr[0].equals("deadline") || inputArr[0].equals("todo")) {
                Task inputTask;

                if (inputArr[0].equals("event")) {
                    String[] eventArr = input.split(" /at ");
                    String[] descriptionSplit = eventArr[0].split(" ");
                    String description = "";
                    for (int i = 1; i < descriptionSplit.length; i++) {
                        description += " " + descriptionSplit[i];
                    }

                    String at = eventArr[1];
                    inputTask = new Event(description, at);

                } else if (inputArr[0].equals("deadline")) {
                    String[] eventArr = input.split(" /by ");
                    String[] descriptionSplit = eventArr[0].split(" ");
                    String description = "";
                    for (int i = 1; i < descriptionSplit.length; i++) {
                        description += " " + descriptionSplit[i];
                    }

                    String by = eventArr[1];
                    inputTask = new Deadline(description, by);

                } else {
                    String description = "";
                    for (int i = 1; i < inputArr.length; i++) {
                        description += " " + inputArr[i];
                    }

                    inputTask = new Todo(description);
                }

                mainList[currIndex] = inputTask;
                currIndex++;
                if (inputTask.toString().length() > maxLength) {
                    maxLength = inputTask.toString().length() + 2;
                }
                
                String count = currIndex == 1 ?
                        "\n\n          Now you have " + currIndex + " task in the list."
                        : "\n\n          Now you have " + currIndex + " tasks in the list.";
                System.out.println("\n" + wrapLine("Honk! Okay added the task:\n            " +
                        inputTask +
                        count));
                input = scanner.nextLine();

            } else {
                System.out.println(wrapLine("Honk honk?"));
                input = scanner.nextLine();
            }
        }
        // when "bye"
        System.out.println(wrapLine("Honk honk!"));
    }

    public static String printList() {
        String formattedList = "";
        for (int i = 0; i < mainList.length; i++) {
            if (mainList[i] == null) {
                break;
            }
            int indexNum = i + 1;
            String item = "           " + indexNum + "." + mainList[i];
            if (i != mainList.length - 1) {
                item += "\n";
            }
            formattedList += item;
        }

        return formattedList;
    }

    public static String wrapLine(String msg) {
        String top = "         ";
        for (int i = 0; i < maxLength; i++) {
            top += "_";
        }
        top += "\n";

        String bottom = "         ";
        String bottomArrow = "         ";
        for (int i = 0; i < maxLength - 4; i++) {
            bottom += "_";
            bottomArrow += " ";
        }
        bottomArrow += "\\ \n";
        bottom += "  __" + "\n" + bottomArrow;

        return top + "\n" + "          " + msg + "\n" + bottom;
    }
}


