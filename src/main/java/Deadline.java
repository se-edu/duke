/**
 * This type of tasks need to be done by a certain deadline.
 */
public class Deadline extends Task {
    private String deadline;

    /**
     * Class constructor.
     *
     * @param description Task description.
     * @param taskType Type of task: Deadline.
     * @param deadline Deadline of task.
     */
    public Deadline(String description, String taskType, String deadline) {
        super(description, taskType);
        this.deadline = deadline;
    }

    /**
     * Returns the deadline of the task.
     *
     * @return deadline of task.
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * Returns all information about the task formatted in a single string.
     *
     * @return Information about task.
     */
    public String obtainTaskInfo() {
        String taskInfo = super.obtainTaskInfo();
        return taskInfo + " " + this.getDeadline();
    }
}
