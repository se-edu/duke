public class Task {
    protected String title;
    protected int index;
    protected boolean done;
    protected String symbol;

    /**
     * Constructor for Task object initializing with 2 attribute.
     * Tracks Tasks and completed Tasks.
     */
    public Task(String title, int index) {
        this.title = title;
        this.index = index;
        this.done = false;
    }

    public void done() {
        this.done = true;
    }

    public String getSymbol() {
        return this.symbol;
    }

}
