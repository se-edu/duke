import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static Task[] mainList;
    private static int maxLength;

    public static void main(String[] args) {
        mainList = new Task[100];
        maxLength = 40;
        int currIndex = 0;
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
        while (!input.equalsIgnoreCase("bye")) {
            if (input.equals("list")) {
                // print list
                System.out.println(wrapLine("Honk! Here's your task list: \n" + printList()));
            } else if (input.subSequence(0,4).equals("done")) {
                // extract list number of task to be marked as done
                char[] inputArr = input.toCharArray();
                int intIndex = 5;
                String taskIndexStr = "";
                while (intIndex < input.length()) {
                    taskIndexStr += inputArr[intIndex];
                    intIndex++;
                }
                int taskIndexInt = Integer.parseInt(taskIndexStr);
                mainList[taskIndexInt - 1].markAsDone();

                String reply = "Okay, I've honked it as done:\n";
                reply += "            [" +
                        mainList[taskIndexInt - 1].getStatusIcon() + "] "
                        + mainList[taskIndexInt - 1];
                System.out.println(wrapLine(reply));
            }
            else {
                // add to list
                Task inputTask = new Task(input);
                mainList[currIndex] = inputTask;
                currIndex++;
                String reply = "added: " + input;
                if (reply.length() > maxLength) {
                    maxLength = reply.length() + 2;
                }
                System.out.println("\n" + wrapLine("added: " + inputTask));
            }
            input = scanner.nextLine();
        }
        System.out.println(wrapLine("Bye bye!"));
    }

    public static String printList() {
        String formattedList = "";
        for (int i = 0; i < mainList.length; i++) {
            if (mainList[i] == null) {
                break;
            }
            int indexNum = i + 1;
            String item = "           " + indexNum + ".[" + mainList[i].getStatusIcon() + "] " + mainList[i];
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

    public static String charArrayListToString(ArrayList<Character> arr) {
        String str = "";
        for (char c : arr) {
            str += c;
        }
        return str;
    }
}


