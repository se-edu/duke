package duke.task;

public abstract class Task implements Comparable<Task> {
    protected String title;
    protected int index;
    protected boolean done;
    protected String symbol;

    /**
     * Constructor for duke.task.Task object initializing with 2 attribute.
     * Tracks title, index and done status.
     * @param index Index of the task.
     * @param title Title of the task.
     */
    public Task(String title, int index) {
        this.title = title;
        this.index = index;
        this.done = false;
    }

    /**
     * Constructor with 3 attribute.
     * Tracks Tasks,
     * @param title title of the task.
     * @param index index of the task.
     * @param don done status of the task.
     */
    public Task(String title, int index, boolean don) {
        this.title = title;
        this.index = index;
        this.done = don;
    }

    public void done() {
        this.done = true;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTitle() {
        return this.title;
    }

    public abstract String getInfo();

    public int compareTo(Task compareTask) {
        if (this.symbol.compareTo(compareTask.symbol) != 0) {
            return this.title.compareTo(compareTask.title);
        } else {
            return (this.symbol.compareTo(compareTask.symbol));
        }
    }

}
