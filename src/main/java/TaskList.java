import java.util.TreeMap;

public class TaskList {
    private TreeMap<Integer, Task> tasks;
    static int index;
    private int removed;

    /**
     * Constructor for Task object initializing with 2 attribute.
     * Tracks Tasks and completed Tasks.
     */
    public TaskList(TreeMap<Integer, Task> tasks) {
        this.tasks = tasks;
        this.index = 1;
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
     * @return returns the deleted Task.
     * @throws NullPointerException if taskIndex not available.
     */
    public Task deleteTask(int taskIndex) throws NullPointerException {
        try {
            taskIndex = taskIndex - removed;
            final Task temp = this.tasks.remove(taskIndex);
            return temp;
        } catch (NullPointerException ex) {
            throw new NullPointerException("Number provided does not exist in the list, please try again.");
        }

    }

    public void addTask(Task task) {
        this.tasks.put(this.index, task);
    }


    public Task getTask(int i) {
        return this.tasks.get(i);
    }


    public TreeMap<Integer, Task> getList() {
        return this.tasks;
    }
}
