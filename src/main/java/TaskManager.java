import java.util.List;
import java.util.ArrayList;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager(int maxTasks) {
        this.tasks = new ArrayList<>(maxTasks);
    }

    public String add(String taskDescription) {
        Task task = new Task(taskDescription);
        this.tasks.add(task);
        return String.format("added: %s", taskDescription);
    }

    public String setDone(int index) {
        if (index > this.tasks.size()) return "Choose properly leh";

        Task task = this.tasks.get(index - 1);
        task.setDone();
        return String.format("Nice! I've marked this task as done: \n%s", task);
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