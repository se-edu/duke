import java.util.Scanner;

public class Duke {
    private static void parseInput() {
        Scanner sc = new Scanner(System.in);
        DukeList dl = new DukeList();

        while (sc.hasNext()) {
            String command = sc.nextLine();

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

                default:
                    dl.addToList(command);
                    System.out.println(DukeFormatting.DIVIDER);
                    System.out.println("   added: " + command);
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



