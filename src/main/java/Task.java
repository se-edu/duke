public class Task {
    protected String description;
    protected boolean isDone;
    protected String taskSymbol = "X";
    public String checkMark = "Done";
    public String cross     = "Not Done";
    //public char checkMark = '\u2713';
    //public char cross     = '\u2718';
    //Cannot print unicode

    public Task (String description) {
        this.description = description;
        this.isDone = false;
    }

    public boolean isItDone() {
        return this.isDone;
    }

    public String getStatus() {
        return (isDone ? checkMark : cross);
    }

    public void markAsDone() {
        this.isDone = true;
        System.out.println ("Nice! You have marked this task as done:\n["
            + checkMark + "] " + this.description);
    }

    public String getSymbol() {
        return this.taskSymbol;
    }

    public String toString() {
        return this.description;
    }
}
