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
            try {
                inputArr = input.split(" ");
                checkInput(inputArr);

                if (inputArr[0].equals("list")) {
                    // print list
                    System.out.println(wrapLine("Honk! Here's your task list: \n" + printList(currIndex)));
                    input = scanner.nextLine();

                } else if (inputArr[0].equals("done")) {
                    // extract list number of task to be marked as done
                    int taskIndex = Integer.parseInt(inputArr[1]);
                    Task selected = mainList[taskIndex - 1];
                    selected.markAsDone();

                    String reply = "Good job! I've honked it as done:\n";
                    System.out.println(wrapLine(reply + "           " + selected));
                    input = scanner.nextLine();

                } else {
                    try {
                        Task inputTask;

                        if (inputArr[0].equals("event")) {
                            inputTask = createEvent(input);

                        } else if (inputArr[0].equals("deadline")) {
                            inputTask = createDeadline(input);

                        } else {
                            inputTask = createTodo(inputArr);
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

                    } catch (GooseEmptyDescriptionException | GooseIllegalFormatException e) {
                        System.err.println(e.getMessage());
                        input = scanner.nextLine();
                    }
                }

            } catch (GooseUnrecognisedException e) {
                System.err.println(e.getMessage());
                input = scanner.nextLine();
            }
        }
        // when "bye"
        System.out.println(wrapLine("Honk honk!"));
    }

    public static Event createEvent(String input) throws GooseEmptyDescriptionException, GooseIllegalFormatException {
        String[] eventArr = input.split(" /at ");
        String[] descriptionSplit = eventArr[0].split(" ");
        String description = "";
        for (int i = 1; i < descriptionSplit.length; i++) {
            description += " " + descriptionSplit[i];
        }

        if (description.isEmpty()) {
            throw new GooseEmptyDescriptionException(wrapLine("Honk! Description of an event cannot be empty."));
        } else {
            if (eventArr.length == 1) {
                throw new GooseIllegalFormatException(wrapLine("Honk! No event date specified."));
            }

            String at = eventArr[1];
            return new Event(description, at);
        }
    }

    public static Deadline createDeadline(String input) throws GooseEmptyDescriptionException, GooseIllegalFormatException {
        String[] deadlineArr = input.split(" /by ");
        String[] descriptionSplit = deadlineArr[0].split(" ");
        String description = "";
        for (int i = 1; i < descriptionSplit.length; i++) {
            description += " " + descriptionSplit[i];
        }

        if (description.isEmpty()) {
            throw new GooseEmptyDescriptionException(wrapLine("Honk! Description of a deadline cannot be empty."));
        } else {
            if (deadlineArr.length == 1) {
                throw new GooseIllegalFormatException(wrapLine("Honk! No deadline specified."));
            }

            String by = deadlineArr[1];
            return new Deadline(description, by);
        }
    }

    public static Todo createTodo(String[] inputArr) throws GooseEmptyDescriptionException {
        String description = "";
        for (int i = 1; i < inputArr.length; i++) {
            description += " " + inputArr[i];
        }

        if (description.isEmpty()) {
            throw new GooseEmptyDescriptionException(wrapLine("Honk! Description of a todo cannot be empty."));
        } else {
            return new Todo(description);
        }
    }

    public static void checkInput(String[] inputArr) throws GooseUnrecognisedException {
        if (!inputArr[0].equals("list") && !inputArr[0].equals("done") && !inputArr[0].equals("deadline") &&
                !inputArr[0].equals("event") && !inputArr[0].equals("todo") ||
                    inputArr[0].equals("list") && inputArr.length > 1) {
            throw new GooseUnrecognisedException(wrapLine("Honk honk??"));
        }
    }

    public static String printList(int currIndex) {
        String formattedList = "";
        if (currIndex == 0) {
            formattedList = "           You haven't added any tasks. Honk...";
        } else {
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


