/**
 * Represents a task.
 */
public class Task {
    /** Description of task.*/
    protected String description;
    /** Boolean flag of whether task is done.*/
    protected boolean isDone;

    /** Task Constructor.*/
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Retrieves status icon for task.
     * */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /** Set boolean isDone as true.*/
    public void markAsDone(){
        isDone = true;
    }

}