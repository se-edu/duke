import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Duke {
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";

        String logo = " _________                        \n" +
                " __  ____/_______________________ \n" +
                " _  / __ _  __ \\  __ \\_  ___/  _ \\  >(o )___\n" +
                " / /_/ / / /_/ / /_/ /(__  )/  __/   ( ._> /\n" +
                " \\____/  \\____/\\____//____/ \\___/     `---'";

        System.out.println("Hello it's\n" + logo);

        String greeting = "  Honk, this Goose. Do you need help with something?\n\n";
        System.out.println("\n" + greeting);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("bye") && !input.equals("Bye")) {
            System.out.println("\n" + wrapLine(input));
            input = scanner.nextLine();
        }
        System.out.println(wrapLine("Bye bye!"));
    }

    public static String wrapLine(String msg) {
        int MAX_LENGTH = 30;
        String top = "          ______________________________\n" +
                "         /                              \\";
        char[] inputArr = msg.toCharArray();
        int len = inputArr.length;
        String formattedMsg = "";

        // format long strings to fit into chat bubble
        if (len <= MAX_LENGTH) {
            int remainingLen = MAX_LENGTH - len;
            formattedMsg = "        | " + msg;
            for (int k = 0; k < remainingLen; k++) {
                formattedMsg += " ";
            }
            formattedMsg += " |";
        } else {
            int currLen = len;
            ArrayList<Character> formattedLineArr = new ArrayList<Character>();
            int startIndex = 0;
            while (currLen > MAX_LENGTH) {
                int cutIndex = MAX_LENGTH + startIndex;
                while (inputArr[cutIndex] != ' ' && cutIndex >= -1) {
                    cutIndex--;
                }

                //if the word is longer than 14 chars
                if (cutIndex == -1) {
                    System.out.println("Error: A word is too long, my brain cannot compute.");
                }

                for (int i = startIndex; i < cutIndex; i++) {
                    formattedLineArr.add(inputArr[i]);
                }
                for (int j = cutIndex - startIndex; j < MAX_LENGTH; j++) {
                    formattedLineArr.add(' ');
                }

                String newLine = charArrayListToString(formattedLineArr);
                formattedMsg = formattedMsg + "        | " + newLine + " |" + "\n";

                currLen -= cutIndex;
                startIndex = cutIndex + 1;
                formattedLineArr.clear();
            }

            // add in the remaining parts of the msg
            int remainingLen = MAX_LENGTH - len + startIndex;
            for (int j = startIndex; j < len; j++) {
                formattedLineArr.add(inputArr[j]);
            }
            for (int k = 0; k < remainingLen; k++) {
                formattedLineArr.add(' ');
            }
            String newLine = charArrayListToString(formattedLineArr);
            formattedMsg = formattedMsg + "        | " + newLine + " |";
        }

        String bottom = "         \\___________________________  _/\n" +
                "                                     \\\n";

        return top + "\n" + formattedMsg + "\n" + bottom;
    }

    public static String charArrayListToString(ArrayList<Character> arr) {
        String str = "";
        for (char c : arr) {
            str += c;
        }
        return str;
    }
}


