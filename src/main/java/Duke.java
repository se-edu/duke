import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    static List<Task> list = new ArrayList<>(100);
    static int longest = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String logo = " _____     _                          \n"
                + "|     |___| |_ ___ ___ ___ ___ ___ ___ \n"
                + "|   --| .'|  _| . | -_|  _|_ -| . |   |\n"
                + "|_____|__,|_| |  _|___|_| |___|___|_|_|\n"
                + "              |_|                      \n"
                + "how may i sewve u today nya?";
        System.out.println("hewwo fwom\n" + logo);
        String[] line = br.readLine().split(" ");
        String cmd = line[0];
        while (!cmd.equals("bye")) {
            switch (cmd) {
                case "list":
                    System.out.print(formatList());
                    break;
                case "done":
                    Task task = list.get(Integer.parseInt(line[1]) - 1);
                    task.markDone();
                    System.out.print(formatReply("Nyice ;;w;;  I've mawked this task as donye: \n\t"
                                    + task,
                            (task.getDescription().length() + 4 < 45 ? 45 : task.getDescription().length() + 4)));
                    break;
                default:
                    StringBuilder description = new StringBuilder("");
                    for (String word : line) {
                        description.append(word + " ");
                    }
                    if (description.length() > longest) {
                        longest = description.length() + 7;
                    }
                    list.add(new Task(description.toString()));
                    System.out.print(formatReply("added: "
                            + description.toString(), 7 + description.length()));
                    break;
            }
            line = br.readLine().split(" ");
            cmd = line[0];
        }
        System.out.print(formatReply("Bye. Hope to see you again soon >w<", 35));
    }

    private static String formatReply(String line, int borderLength) {
        StringBuilder sb = new StringBuilder("\t");
        for (int i = 0; i < borderLength; i++) {
            sb.append("*");
        }
        sb.append("\n\t");
        sb.append(line);
        sb.append("\n\t");
        for (int i = 0; i < borderLength; i++) {
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
