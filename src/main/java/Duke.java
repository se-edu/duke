import java.util.Scanner;

public class Duke {
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
            System.out.print(formatReply(line));
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
}
