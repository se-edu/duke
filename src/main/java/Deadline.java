public class Deadline extends Task {

    protected String deadline;
    protected String taskSymbol = "D";

    public Deadline (String description, String deadline) {
        super (description);
        this.deadline = deadline;
    }

    public String getDeadline() {
        return this.deadline;
    }

    @Override
    public String toString() {
        if (super.isDone) {
            return ("[" + taskSymbol + "][Done] " + super.description
                    + " (by: " + this.deadline + ")");
        } else {
            return ("[" + taskSymbol + "][Not Done] " + super.description
                    + " (by: " + this.deadline + ")");
        }
    }
}
