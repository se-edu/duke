package seedu.duke;

public class Deadline extends Task {
    /**
     * Attribute enddate tracks the deadline input for the task.
     */
    private final String endDate;

    /**
     * Creates a deadline.
     * @param taskName for task name
     * @param date for end date
     */
    Deadline(String taskName, String date) {
        super(taskName, false);
        this.endDate = date;
    }

    /**
     * Used to help adjust the done status.
     * @param oldDeadline to extract task name and date
     * @param done for specified boolean
     */
    Deadline(Deadline oldDeadline, boolean done) {
        super(oldDeadline.getTaskName(), done);
        this.endDate = oldDeadline.getDate();
    }

    /**
     * Returns date as a string.
     * @return String date
     */
    String getDate() {
        return this.endDate;
    }

    /**
     * returns a new Task with the specified attribute 'done' based on boolean 'status'.
     * @param status to provide boolean
     * @return new Task with specified boolean for attribute 'done'
     */
    @Override
    public Task changeTaskStatus(boolean status) {
        return new Deadline(this, status);
    }

    /**
     * prints the task string with [D] to annotate.
     * @return String task information
     */
    @Override
    public String toString() {
        return "[D]" + super.toString();
    }
}
