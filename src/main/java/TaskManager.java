import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager(int maxTasks) {
        this.tasks = new ArrayList<>(maxTasks);
    }

    public String addTodoTask(String args) {
        Task task = new Task(args);
        return this.add(task);
    }

    public String addDeadlineTask(String args) {
        String[] splitArgs = args.split("/by");
        if (splitArgs.length != 2) System.out.println("Too many or too few arguments");

        Task task = new DeadlineTask(splitArgs[0].trim(), splitArgs[1].trim());
        return this.add(task);
    }

    public String addEventTask(String args) {
        String[] splitArgs = args.split("/at");
        if (splitArgs.length != 2) System.out.println("Too many or too few arguments");

        Task task = new EventTask(splitArgs[0].trim(), splitArgs[1].trim());
        return this.add(task);
    }

    private String add(Task task) {
        this.tasks.add(task);
        return String.format(
            "Got it. I've added this task:\n" +
            "  %s\n" +
            "Now you have %d tasks in the list.\n", task, this.tasks.size()
        );
    }

    public String setDone(String args) {
        String[] splitArgs = args.split(" ");
        if (splitArgs.length != 1) System.out.println("Too many or too few arguemnts");;
        
        int index = Integer.parseInt(splitArgs[0]);
        if (index > this.tasks.size() || index < 1) return "Choose properly leh";

        Task task = this.tasks.get(index - 1);
        task.setDone();
        return String.format(
            "Nice! I've marked this task as done: \n%s", task
        );
    }

    @Override
    public String toString() {
        if (this.tasks.size() == 0) {
            return "Add something lehh";
        }

        StringBuilder sb = new StringBuilder("You need to do dis lah: \n");
        for (int i = 0; i < this.tasks.size(); i++) {
            sb.append(String.format("%d. %s\n", i + 1, this.tasks.get(i)));
        }
        return sb.toString();
    }
}