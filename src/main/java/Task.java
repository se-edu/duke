/**
 * Each object of class Task represents a task to be saved.
 */
public class Task {
    private String description;
    private boolean isDone;

    /**
     * Class constructor.
     *
     * @param description Task description.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns symbol representing status of task.
     *
     * @return If task is done, return tick symbol, else return X symbol.
     */
    public String getStatusIcon() {
        if (isDone) {
            return ("\u2713");
        } else {
            return ("\u2718");
        }
    }

    /**
     * Returns description of task.
     *
     * @return description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Mark task as done.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Returns all information about the task formatted in a single string.
     *
     * @return return information about task.
     */
    public String obtainTaskInfo() {
        return "[" + this.getStatusIcon() + "] " + this.getDescription();
    }
}
