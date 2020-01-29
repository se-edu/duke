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
                                    + task));
                    break;
                default:
                    StringBuilder description = new StringBuilder("");
                    Task newTask;
                    boolean option = false;
                    switch (cmd) {
                        case "deadline":
                            StringBuilder by = new StringBuilder("");
                            for (int i = 1; i < line.length; i++) {
                                if (option) {
                                    if (i != line.length - 1) {
                                        by.append(line[i]).append(" ");
                                    } else {
                                        by.append(line[i]);
                                    }
                                } else if (line[i].equals("/by")) {
                                    option = true;
                                } else {
                                    description.append(line[i]).append(" ");
                                }
                            }
                            newTask = new Deadline(description.toString(), by.toString());
                            break;
                        case "event":
                            StringBuilder at = new StringBuilder("");
                            for (int i = 1; i < line.length; i++) {
                                if (option) {
                                    if (i != line.length - 1) {
                                        at.append(line[i]).append(" ");
                                    } else {
                                        at.append(line[i]);
                                    }
                                } else if (line[i].equals("/at")) {
                                    option = true;
                                } else {
                                    description.append(line[i]).append(" ");
                                }
                            }
                            newTask = new Event(description.toString(), at.toString());
                            break;
                        default:
                            for (int i = 1; i < line.length; i++) {
                                description.append(line[i]).append(" ");
                            }
                            if (description.length() > longest) {
                                longest = description.length() + 10;
                            }
                            newTask = new Todo(description.toString());
                            break;
                    }
                        list.add(newTask);
                        System.out.print(formatReply("Got it UwU I've added this task: \n\t"
                                + newTask + "\n\t" + countList()));
                    break;
            }
            line = br.readLine().split(" ");
            cmd = line[0];
        }
        System.out.print(formatReply("Bye. Hope to see you again soon >w<"));
    }

    private static String formatReply(String line) {
        StringBuilder sb = new StringBuilder("\t");
        sb.append("*".repeat(60)).append("\n\t");
        sb.append(line).append("\n\t");
        sb.append("*".repeat(60)).append("\n");
        return sb.toString();
    }

    private static String formatList() {
        StringBuilder sb = new StringBuilder("\t");
        sb.append("*".repeat(60)).append("\n\tHewe awe the tasks in youw wist:\n\t");
        if (list.size() == 0) {
            sb.append("list is empty qwq\n\t");
        } else {
            for (int i = 1; i <= list.size(); i++) {
                sb.append(i).append(". ").append(list.get(i - 1)).append("\n\t");
            }
        }
        sb.append("*".repeat(60)).append("\n");
        return sb.toString();
    }

    private static String countList() {
        return "Nyow you have " + list.size() + " tasks in the wist.";
    }
}
