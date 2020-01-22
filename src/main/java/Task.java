import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class Task {
    private TreeMap<Integer,String> tasks;
    private HashSet<String> tasksDone;
    private int index;

    /**
     * Constructor for Task object initializing with 2 attribute.
     * Tracks Tasks and completed Tasks.
     */
    public Task() {
        this.tasks = new TreeMap<>();
        this.tasksDone = new HashSet<>();
        this.index = 1;
    }

    /**
     * Mark the tasks that are fulfilled.
     * @param num used to locate the specific tasks.
     */
    public void doneTask(int num) {
        String temp = this.tasks.get(num);
        this.tasksDone.add(temp);
        System.out.println(String.format("%80s",' ').replace(' ','*'));
        System.out.println(String.format("* %-77s*",' '));
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(String.format("* [✓] %-73s*",temp));
    }

    /**
     * Adds task into the tasks list.
     * @param message use to store it in the tasks.
     */
    public void addTask(String message) {
        this.tasks.put(this.index, message);
        System.out.println(String.format("%80s",' ').replace(' ','*'));
        System.out.println(String.format("* %-77s*",' '));
        System.out.println(String.format("* %-77s*", message + " is added to your task list"));
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
        for (Map.Entry<Integer,String> entry : tasks.entrySet()) {
            int counter = entry.getKey();
            String message = entry.getValue();
            if (this.tasksDone.contains(message)) {
                System.out.println(String.format("* %d.[✓] %-71s*", counter, message));
            } else {
                System.out.println(String.format("* %d.[✗] %-71s*", counter, message));
            }
        }
        System.out.println(String.format("* %-77s*",' '));
        System.out.println(String.format("%80s",' ').replace(' ','*'));
    }
}
