import java.util.Scanner;

public class Duke {

    private static void parseInput() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String command = sc.next();

            switch (command) {
                case "list":
                    System.out.println(DukeFormatting.DIVIDER +
                            DukeFormatting.LIST + DukeFormatting.DIVIDER);
                    break;
                case "blah":
                    System.out.println(DukeFormatting.DIVIDER + DukeFormatting.BLAH
                            + DukeFormatting.DIVIDER);
                    break;
                case "bye":
                    System.out.println(DukeFormatting.DIVIDER + DukeFormatting.BYE
                            + DukeFormatting.DIVIDER);
                    break;
            }

            if (command.equals("bye")) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(DukeFormatting.DIVIDER + DukeFormatting.LOGO
                + "Hello! I'm Duke! " +
                "\nThese are my commands: list, blah, bye. " +
                "\nWhat can I do for you?\n" + DukeFormatting.DIVIDER);

        parseInput();
    }
}



