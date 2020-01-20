import java.util.Scanner;

public class Duke {
    private static final String LOGO =  "        8888888b.           888\n"
            + "        888  \"Y88b          888\n"
            + "        888    888          888\n"
            + "        888    888 888  888 888  888  .d88b.\n"
            + "        888    888 888  888 888 .88P d8P  Y8b\n"
            + "        888    888 888  888 888888K  88888888\n"
            + "        888  .d88P Y88b 888 888 \"88b Y8b.\n"
            + "        8888888P\"   \"Y88888 888  888  \"Y8888=\n\n";
    private static final String DIVIDER = "______________________________________________________\n";
    private static final String LIST = "list\n";
    private static final String BLAH = "blah\n";
    private static final String BYE = "Bye. Hope to see you again soon!\n";

    private static void parseInput() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String command = sc.next();

            switch (command) {
                case "list":
                    System.out.println(DIVIDER + LIST + DIVIDER);
                    break;
                case "blah":
                    System.out.println(DIVIDER + BLAH + DIVIDER);
                    break;
                case "bye":
                    System.out.println(DIVIDER + BYE + DIVIDER);
                    break;
            }

            if (command.equals("bye")) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(DIVIDER + LOGO + "Hello! I'm Duke! " +
                "\nThese are my commands: list, blah, bye. " +
                "\nWhat can I do for you?\n" + DIVIDER);

        parseInput();
    }
}



