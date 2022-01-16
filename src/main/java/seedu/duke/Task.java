package seedu.duke;


public class Task {
    private final String taskName;
    private final boolean done;

    /**
     * Constructor for a task
     * @param name refers to the task name
     */
    Task(String name) {
        this.taskName = name;
        this.done = false;
    }

    /**
     * Constructor for a task that consists of task name and boolean that marks whether the task has been completed
     * @param name refers to the task name
     * @param done refers to the boolean that tracks if a task is complete
     */
    Task(String name, Boolean done) {
        this.taskName = name;
        this.done = done;
    }

    /**
     * Checks whether the task has been completed
     * @return boolean of this.done
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Marks task as done
     * @return new Task with boolean attribute 'done' being marked as true
     */
    Task completeTask() {
        return new Task(this.taskName, true);
    }

    /**
     * Marks task as undone
     * @return new Task with boolean attribute 'done' being marked as false
     */
    Task uncompleteTask() {
        return new Task(this.taskName, false);
    }

    @Override
    public String toString() {
        String marked = this.isDone() ? "X" : " ";
        return String.format("[%s] %s", marked, this.taskName);
    }
}
