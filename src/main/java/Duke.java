import java.util.Scanner;

public class Duke {
    private static void parseInput() {
        Scanner sc = new Scanner(System.in);
        DukeList dl = new DukeList();

        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] lineArr = line.split(" ");
            String command = lineArr[0];

            switch (command) {
                case "list":
                    System.out.println(DukeFormatting.DIVIDER);
                    dl.printList();
                    System.out.println(DukeFormatting.DIVIDER);
                    break;

                case "blah":
                    System.out.println(DukeFormatting.DIVIDER + DukeFormatting.BLAH
                            + DukeFormatting.DIVIDER);
                    break;

                case "bye":
                    System.out.println(DukeFormatting.DIVIDER + DukeFormatting.BYE
                            + DukeFormatting.DIVIDER);
                    break;

                case "done":
                    int index = Integer.parseInt(lineArr[1]) - 1;
                    dl = dl.setDone(index);
                    System.out.println(DukeFormatting.DIVIDER);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("      " + dl.printTask(index));
                    System.out.println(DukeFormatting.DIVIDER);
                    break;

                default:
                    dl.addToList(line);
                    System.out.println(DukeFormatting.DIVIDER);
                    System.out.println("   added: " + line);
                    System.out.println(DukeFormatting.DIVIDER);
                    break;
            }

            if (command.equals("bye")) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(DukeFormatting.DIVIDER + DukeFormatting.LOGO
                + "   Hello! I'm Duke! " +
                "\n   What can I do for you?\n" + DukeFormatting.DIVIDER);

        parseInput();
    }
}



