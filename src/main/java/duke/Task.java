package duke;

/** Represents a task.
 */
public class Task {
    private String description;
    private boolean isDone;

    /** Creates a task of with
     * the specified description and end date.
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /** Gets the current status of the task
     * @return a string representation of the
     * status of the task
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * @return a string that represents the task.
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /** Prints the string representation of the
     * task that is to be saved in the file.
     * @return a string representation of the
     * task to be saved in the file.
     */
    public String printToFile() {
        return " - " + getStatusIcon() + " " + description;
    }
}