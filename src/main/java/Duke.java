import java.util.Scanner;

public class Duke {
    private static void parseInput() {
        Scanner sc = new Scanner(System.in);
        DukeList dl = new DukeList();

        while (sc.hasNext()) {
            String command = sc.next();

            switch (command) {
                case "list":
                    sc.nextLine();
                    System.out.println(DukeFormatting.DIVIDER);
                    dl.printList();
                    System.out.println(DukeFormatting.DIVIDER);
                    break;

                case "bye":
                    sc.nextLine();
                    System.out.println(DukeFormatting.DIVIDER + DukeFormatting.BYE
                            + DukeFormatting.DIVIDER);
                    break;

                case "done":
                    String str = sc.nextLine().trim();
                    int index = Integer.parseInt(str) - 1;
                    dl = dl.setDone(index);
                    System.out.println(DukeFormatting.DIVIDER);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("      " + dl.printTask(index));
                    System.out.println(DukeFormatting.DIVIDER);
                    break;

                case "todo":
                case "deadline":
                case "event":
                    String description = sc.nextLine();
                    try {
                        if (description.replace("\n", "").replace(" ", "").length() == 0) {
                            throw new MissingDescriptionException("༼ つ◕_◕ ༽つ The description of a " + command
                                    + " cannot be empty.\n   Please try again!");
                        } else {
                            Task task;
                            if (command.equals("todo")) {
                                task = new ToDoTask(description, false);
                            } else {
                                String[] arr = description.split(" /");

                                if (arr.length == 1) {
                                    throw new MissingDateTimeException("(''⊙＿⊙) The date and time of the "
                                            + command + " is missing.\n   Please try again!");
                                }
                                task = command.equals("deadline")
                                        ? new DeadlineTask(arr[0], false, arr[1])
                                        : new EventTask(arr[0], false, arr[1]);
                            }

                            dl = dl.addToList(task);
                            System.out.println(DukeFormatting.DIVIDER
                                    + DukeFormatting.ADDED
                                    + "      " + task.toString()
                                    + "\n   Now you have " + dl.listSize()
                                    + (dl.listSize() == 1 ? " task" : " tasks")
                                    + " in the list.\n"
                                    + DukeFormatting.DIVIDER);
                        }

                    } catch (MissingDescriptionException | MissingDateTimeException e) {
                        System.out.println(DukeFormatting.DIVIDER
                                + "   " + e.getMessage() + "\n"
                                + DukeFormatting.DIVIDER);
                    }
                    break;

                default:
                    try {
                        throw new InvalidCommandArgumentException("(つ╥﹏╥)つ Hey, I can't do that for you. " +
                                "\n   I don't know " + command + "...");
                    } catch (InvalidCommandArgumentException e) {
                        System.out.println(DukeFormatting.DIVIDER
                                + "   " + e.getMessage() + "\n"
                                + DukeFormatting.DIVIDER);
                    }
                    break;
            }

            if (command.equals("bye")) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(DukeFormatting.HELLO);
        parseInput();
    }
}



