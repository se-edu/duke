import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasksList = new ArrayList<Task>();

    public ArrayList<Task> getTasksList() {
        return tasksList;
    }

    public int getNumberOfTasks() {
        return tasksList.size();
    }

    public void addTask(String description) {
        tasksList.add(new Task(description));
    }

    public boolean markTaskAsDone(int indexOfTask) {
        try {
            Task task = tasksList.get(indexOfTask);
            task.markAsDone();
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }}
