package duke.task;

import java.util.Map;
import java.util.TreeMap;

public class TaskList {
    private TreeMap<Integer, Task> tasks;
    public static int index;
    private int removed;

    /**
     * Constructor for duke.task.Task object initializing with 2 attribute.
     * Tracks Tasks and completed Tasks.
     */
    public TaskList(TreeMap<Integer, Task> tasks) {
        this.tasks = tasks;
        this.index = tasks.size() + 1;
        this.removed = 0;
    }

    /**
     * Create new taskList if there are no saved progress.
     */
    public TaskList() {
        this.tasks = new TreeMap<>();
        this.index = 1;
        this.removed = 0;
    }


    /**
     * Mark the tasks that are fulfilled.
     * @param num used to locate the specific tasks.
     */
    public Task doneTask(int num) {
        Task temp = this.tasks.get(num);
        temp.done();
        return temp;
    }

    /**
     * Deletes task from the task List.
     * @param taskIndex taskIndex use to retrieve task.
     * @return returns the deleted duke.task.Task.
     * @throws NullPointerException if taskIndex not available.
     */
    public Task deleteTask(int taskIndex) throws NullPointerException {
        try {
            final Task temp = this.tasks.remove(taskIndex + removed);
            this.removed++;
            return temp;
        } catch (NullPointerException ex) {
            throw new NullPointerException("Number provided does not exist in the list, please try again.");
        }

    }

    public void addTask(Task task) {
        this.tasks.put(this.index, task);
        this.index++;
    }


    public Task getTask(int i) {
        return this.tasks.get(i);
    }


    public TreeMap<Integer, Task> getList() {
        return this.tasks;
    }

    public TreeMap<Integer, Task> findTask(String find) {
        int newIndex = 1;
        TreeMap<Integer, Task> newTasks = new TreeMap<>();
        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            Task task = entry.getValue();
            String message = task.getTitle();
            if (message.contains(find)) {
                newTasks.put(newIndex, task);
                newIndex++;
            }
        }
        return newTasks;
    }
}
