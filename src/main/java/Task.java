public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markDone() {
        isDone = true;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[" + (isDone ? "\u2713" : "\u2718") + "] " + description;
    }
}