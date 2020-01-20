public class Task {
    protected String description;
    protected boolean isDone;

    public Task (String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatus() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public void markAsDone() {
        this.isDone = true;
        System.out.println ("Nice! You have marked this task as done:\n "
            + "\u2713 " + this.description);
    }

    public String toString() {
        return this.description;
    }
}
