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
                    int index = sc.nextInt() - 1;
                    sc.nextLine();
                    dl = dl.setDone(index);
                    System.out.println(DukeFormatting.DIVIDER);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("      " + dl.printTask(index));
                    System.out.println(DukeFormatting.DIVIDER);
                    break;

                case "todo":
                    String description = sc.nextLine();
                    ToDoTask tTask = new ToDoTask(description, false);
                    dl = dl.addToList(tTask);

                    System.out.println(DukeFormatting.DIVIDER
                            + DukeFormatting.ADDED
                            + "      " + tTask.toString()
                            + "\n   Now you have " + dl.listSize()
                            + (dl.listSize() == 1 ? " task" : " tasks")
                            + " in the list.\n"
                            + DukeFormatting.DIVIDER);
                    break;

                case "deadline":
                    String line = sc.nextLine();
                    String[] lineArr = line.split(" /");
                    DeadlineTask dTask = new DeadlineTask(lineArr[0], false, lineArr[1]);
                    dl = dl.addToList(dTask);

                    System.out.println(DukeFormatting.DIVIDER
                            + DukeFormatting.ADDED
                            + "      " + dTask.toString()
                            + "\n   Now you have " + dl.listSize()
                            + (dl.listSize() == 1 ? " task" : " tasks")
                            + " in the list.\n"
                            + DukeFormatting.DIVIDER);

                case "event":
                    String text = sc.nextLine();
                    String[] textArr = text.split(" /");
                    DeadlineTask eTask = new DeadlineTask(textArr[0], false, textArr[1]);
                    dl = dl.addToList(eTask);

                    System.out.println(DukeFormatting.DIVIDER
                            + DukeFormatting.ADDED
                            + "      " + eTask.toString()
                            + "\n   Now you have " + dl.listSize()
                            + (dl.listSize() == 1 ? " task" : " tasks")
                            + " in the list.\n"
                            + DukeFormatting.DIVIDER);
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



