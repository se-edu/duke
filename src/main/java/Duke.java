import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    static List<String> list = new ArrayList<>(100);
    static int longest = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String logo = " _____     _                          \n"
                + "|     |___| |_ ___ ___ ___ ___ ___ ___ \n"
                + "|   --| .'|  _| . | -_|  _|_ -| . |   |\n"
                + "|_____|__,|_| |  _|___|_| |___|___|_|_|\n"
                + "              |_|                      \n"
                + "how may i sewve u today nya?";
        System.out.println("hewwo fwom\n" + logo);
        String line = sc.nextLine();
        while (!line.equals("bye")) {
            if (line.equals("list")) {
                System.out.print(formatList());
            } else {
                if (line.length() > longest) {
                    longest = line.length() + 3;
                }
                list.add(line);
                System.out.print(formatReply("added: " + line));
            }

            line = sc.nextLine();
        }
        System.out.print(formatReply("Bye. Hope to see you again soon >w<"));
    }

    private static String formatReply(String line) {
        StringBuilder sb = new StringBuilder("\t");
        for (int i = 0; i < line.length(); i++) {
            sb.append("*");
        }
        sb.append("\n\t");
        sb.append(line);
        sb.append("\n\t");
        for (int i = 0; i < line.length(); i++) {
            sb.append("*");
        }
        sb.append("\n");
        return sb.toString();
    }

    private static String formatList() {
        StringBuilder sb = new StringBuilder("\t");
        if (list.size() == 0) {
            for (int i = 0; i < 17; i++) {
                sb.append("*");
            }
            sb.append("\n\t");
            sb.append("list is empty qwq\n\t");
            for (int i = 0; i < 17; i++) {
                sb.append("*");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < longest; i++) {
                sb.append("*");
            }
            sb.append("\n\t");
            for (int i = 1; i <= list.size(); i++) {
                sb.append(i + ". " + list.get(i - 1) + "\n\t");
            }
            for (int i = 0; i < longest; i++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
