import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TaskTracker {
    private TreeMap<Integer, Task> tasks;
    private HashSet<Task> tasksDone;
    private int index;
    private int removed;
    private java.nio.file.Path path;

    /**
     * Constructor for Task object initializing with 2 attribute.
     * Tracks Tasks and completed Tasks.
     */
    public TaskTracker() {
        this.tasks = new TreeMap<>();
        this.tasksDone = new HashSet<>();
        this.index = 1;
        this.removed = 0;
        String home = System.getProperty("user.home");
        this.path = java.nio.file.Paths.get(home, "Desktop", "GitHub", "duke","data","data.txt");
    }

    /**
     * Load task from a txt file.
     * @throws IOException Throw exception if no file detected.
     */
    public void loadTask() throws IOException {
        File file = this.path.toFile();
        Scanner scanner = new Scanner(file);
        TreeMap<Integer, Task> tasksTemp = new TreeMap<>();
        int counter = 1;
        while (scanner.hasNextLine()) {
            Task task;
            boolean don = false;
            String data = scanner.nextLine();
            String[] arrMessage = data.split("\\|");
            if (arrMessage[1].equals("1")) {
                don = true;
            }
            if (arrMessage[0].equals("T")) {
                task = new Todo(arrMessage[2], counter, don, Symbol.T);
                tasksTemp.put(counter, task);
            } else if (arrMessage[0].equals("D")) {
                task = new Deadlines(arrMessage[2], counter, don, Symbol.D, arrMessage[3]);
                tasksTemp.put(counter, task);
            } else if (arrMessage[0].equals("E")) {
                task = new Event(arrMessage[2], counter, don, Symbol.E, arrMessage[3]);
                tasksTemp.put(counter, task);
            }
            counter++;
        }
        this.index = counter;
        this.tasks = tasksTemp;
    }

    /**
     * save tasks to a data.txt file.
     * @throws IOException throws exception if no such file.
     */
    public void saveTask() throws IOException {
        File file = this.path.toFile();
        FileWriter writer = new FileWriter(file);
        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            Task task = entry.getValue();
            String message = task.getInfo();
            writer.write(message + "\n");
        }
        writer.close();
    }

    /**
     * Mark the tasks that are fulfilled.
     * @param num used to locate the specific tasks.
     */
    public void doneTask(int num) {
        Task temp = this.tasks.get(num);
        this.tasksDone.add(temp);
        temp.done();
        System.out.println(String.format("%80s",' ').replace(' ','*'));
        System.out.println(String.format("* %-77s*",' '));
        System.out.println(String.format("* %-77s*","Nice! I've marked this task as done:"));
        System.out.println(String.format("* [✓] %-73s*",temp.toString()));
        System.out.println(String.format("* %-77s*",' '));
        System.out.println(String.format("%80s",' ').replace(' ','*'));
    }

    /**
     * Delete the tasks from the task list.
     * @param message whole command use to parse.
     */
    public void deleteTask(String message) throws NullPointerException {
        try {
            int num = Integer.parseInt(message.split(" ")[1]);
            num = num - removed;
            final Task temp = this.tasks.remove(num);
            num++;
            System.out.println(String.format("%80s", ' ').replace(' ', '*'));
            System.out.println(String.format("* %-77s*", ' '));
            System.out.println(String.format("* %-77s*", "Noted. I've removed this task:"));
            System.out.println(String.format("* [✓] %-73s*", temp.toString()));
            System.out.println(String.format("* %-77s*", ' '));
            System.out.println(String.format("%80s", ' ').replace(' ', '*'));
        } catch (NullPointerException ex) {
            throw new NullPointerException("Number provided does not exist in the list, please try again.");
        }

    }

    /**
     * Adds task into the tasks list.
     * @param message use to store it in the tasks.
     */
    public void addTask(String message, Symbol symbol) throws DukeException,IOException {
        String[] arrMessage = message.split(" ");
        System.out.println(this.index);
        Task task;
        if (symbol == Symbol.T) {
            String[] tempArr = Arrays.copyOfRange(arrMessage,1,arrMessage.length);
            String newMessage = String.join(" ", tempArr);
            task = new Todo(newMessage, this.index, symbol);
        } else if (symbol == Symbol.D) {
            int landmark = arrMessage.length;
            for (int i = 1; i < arrMessage.length; i++) {
                if (arrMessage[i].equals("/by")) {
                    landmark = i;
                    break;
                }
            }
            if (landmark == arrMessage.length) {
                throw new DukeException("  ☹ OOPS!!! The description of a deadline cannot be empty.");
            }
            String[] tempArr = Arrays.copyOfRange(arrMessage, 1, landmark);
            String[] tempArr2 = Arrays.copyOfRange(arrMessage, landmark + 1, arrMessage.length);
            String newMessage = String.join(" ", tempArr);
            String newDate = String.join(" ", tempArr2);
            task = new Deadlines(newMessage, this.index, symbol, newDate);
        } else {
            int landmark = arrMessage.length;
            for (int i = 1; i < arrMessage.length; i++) {
                if (arrMessage[i].equals("/at")) {
                    landmark = i;
                    break;
                }
            }
            if (landmark == arrMessage.length) {
                throw new DukeException("  ☹ OOPS!!! The description of a event cannot be empty.");
            }
            String[] tempArr = Arrays.copyOfRange(arrMessage, 1, landmark);
            String[] tempArr2 = Arrays.copyOfRange(arrMessage, landmark + 1, arrMessage.length);
            String newMessage = String.join(" ", tempArr);
            String newDate = String.join(" ", tempArr2);
            task = new Event(newMessage, this.index, symbol, newDate);
        }
        this.tasks.put(this.index, task);
        System.out.println(String.format("%80s",' ').replace(' ','*'));
        System.out.println(String.format("* %-77s*",' '));
        System.out.println(String.format("* %-77s*", "Got it. I've added this task:"));
        System.out.println(String.format("* %-77s*", task.toString()));
        System.out.println(String.format("* %-77s*",' '));
        System.out.println(String.format("%80s",' ').replace(' ','*'));
        this.index++;
        this.saveTask();
    }

    /**
     * Prints all the tasks stored.
     */
    public void printStoredTask() {
        System.out.println(String.format("%80s",' ').replace(' ','*'));
        System.out.println(String.format("* %-77s*",' '));
        int counter = 1;
        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            Task message = entry.getValue();
            System.out.println(String.format("* %d.%-75s*", counter, message));
            counter++;
        }
        System.out.println(String.format("* %-77s*",' '));
        System.out.println(String.format("%80s",' ').replace(' ','*'));
    }
}
