import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Duke {
    private static String[] mainList;
    private static int maxLength;

    public static void main(String[] args) {
        mainList = new String[100];
        maxLength = 30;
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
        while (!input.equals("bye") && !input.equals("Bye")) {
            if (input.equals("list")) {
                // print list
                System.out.println(wrapLine("Here's your list: \n" + printList()));
            } else {
                // add to list
                mainList[currIndex] = input;
                currIndex++;
                String reply = "added: " + input;
                if (reply.length() > maxLength) {
                    maxLength = reply.length() + 2;
                }
                System.out.println("\n" + wrapLine("added: " + input));
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
            String item = "           " + indexNum + ". " + mainList[i];
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


