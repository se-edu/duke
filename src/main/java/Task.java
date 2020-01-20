public class Task {
    protected String description;
    protected String status = "Not Done";

    public Task (String description) {
        this.description = description;
    }

    public void markAsDone() {
        this.status = "Done";
        System.out.println ("Nice! I've marked this task as done:\n"
                + "[" + this.status + "] " + this.description);
    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "[" + this.status + "] " + this.description;
    }
}