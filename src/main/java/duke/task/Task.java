package duke.task;

public abstract class Task {
    protected String title;
    protected int index;
    protected boolean done;
    protected String symbol;

    /**
     * Constructor for duke.task.Task object initializing with 2 attribute.
     * Tracks Tasks and completed Tasks.
     */
    public Task(String title, int index) {
        this.title = title;
        this.index = index;
        this.done = false;
    }

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

    public abstract String getInfo();

}
