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

}
