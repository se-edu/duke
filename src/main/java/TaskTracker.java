import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class TaskTracker {
    private TreeMap<Integer, Task> tasks;
    private HashSet<Task> tasksDone;
    private int index;

    /**
     * Constructor for Task object initializing with 2 attribute.
     * Tracks Tasks and completed Tasks.
     */
    public TaskTracker() {
        this.tasks = new TreeMap<>();
        this.tasksDone = new HashSet<>();
        this.index = 1;
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
     * Adds task into the tasks list.
     * @param message use to store it in the tasks.
     */
    public void addTask(String message, Symbol symbol) throws IllegalArgumentException {
        String[] arrMessage = message.split(" ");
        Task task;
        if (symbol == Symbol.T) {
            String[] tempArr = Arrays.copyOfRange(arrMessage,1,arrMessage.length);
            String newMessage = String.join(" ", tempArr);
            task = new Todo(message, this.index, symbol);
        } else if (symbol == Symbol.D) {
            int landmark = arrMessage.length;
            for (int i = 1; i < arrMessage.length; i++) {
                if (arrMessage[i].equals("/by")) {
                    landmark = i;
                    break;
                }
            }
            if (landmark == arrMessage.length) {
                throw new IllegalArgumentException("  ☹ OOPS!!! The description of a deadline cannot be empty.");
            }
            String[] tempArr = Arrays.copyOfRange(arrMessage, 1, landmark);
            String[] tempArr2 = Arrays.copyOfRange(arrMessage, landmark + 1, arrMessage.length);
            String newMessage = String.join(" ", tempArr);
            String newDate = String.join(" ", tempArr2);
            task = new Deadlines(newMessage, index, symbol, newDate);
        } else {
            int landmark = arrMessage.length;
            for (int i = 1; i < arrMessage.length; i++) {
                if (arrMessage[i].equals("/at")) {
                    landmark = i;
                    break;
                }
            }
            if (landmark == arrMessage.length) {
                throw new IllegalArgumentException("  ☹ OOPS!!! The description of a event cannot be empty.");
            }
            String[] tempArr = Arrays.copyOfRange(arrMessage, 1, landmark);
            String[] tempArr2 = Arrays.copyOfRange(arrMessage, landmark + 1, arrMessage.length);
            String newMessage = String.join(" ", tempArr);
            String newDate = String.join(" ", tempArr2);
            task = new Event(newMessage, index, symbol, newDate);
        }
        this.tasks.put(this.index, task);
        System.out.println(String.format("%80s",' ').replace(' ','*'));
        System.out.println(String.format("* %-77s*",' '));
        System.out.println(String.format("* %-77s*", "Got it. I've added this task:"));
        System.out.println(String.format("* %-77s*", task.toString()));
        System.out.println(String.format("* %-77s*",' '));
        System.out.println(String.format("%80s",' ').replace(' ','*'));
        this.index++;
    }

    /**
     * Prints all the tasks stored.
     */
    public void printStoredTask() {
        System.out.println(String.format("%80s",' ').replace(' ','*'));
        System.out.println(String.format("* %-77s*",' '));
        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            int counter = entry.getKey();
            Task message = entry.getValue();
            System.out.println(String.format("* %d.%-75s*", counter, message));
        }
        System.out.println(String.format("* %-77s*",' '));
        System.out.println(String.format("%80s",' ').replace(' ','*'));
    }
}
