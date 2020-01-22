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

    @Override
    public String toString() {
        if (this.tasks.size() == 0) {
            return "Add something lehh";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.tasks.size(); i++) {
            sb.append(String.format("%d. %s\n", i + 1, this.tasks.get(i)));
        }
        return sb.toString();
    }
}