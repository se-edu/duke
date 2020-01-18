/**
 * Each object of class Task represents a task to be saved
 */
public class Task {
    private String description;
    private String taskType;
    private boolean isDone;

    /**
     * Class constructor
     * @param description Task description
     * @param taskType Type of task: deadline, event, to-do
     */
    public Task(String description, String taskType) {
        this.description = description;
        this.taskType = taskType;
        this.isDone = false;
    }

    /**
     * Returns symbol representing status of task
     * @return If task is done, return tick symbol, else return X symbol
     */
    public String getStatusIcon() {
        if (isDone) {
            return ("\u2713");
        } else {
            return ("\u2718");
        }
    }

    /**
     * Returns description of task
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the type of the task
     * @return Type of task
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * Mark task as done
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Returns all information about the task formatted in a single string
     * @return Information about task
     */
    public String obtainTaskInfo() {
        return "[" + this.getTaskType() + "]["
                + this.getStatusIcon() + "] " + this.getDescription();
    }
}
