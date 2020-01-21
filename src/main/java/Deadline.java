

public class Deadline extends Task {

    private String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        int newDeadlineFormat = deadline.indexOf(" ");
        this.deadline = deadline.substring(0, newDeadlineFormat) + ":" + deadline.substring(newDeadlineFormat);


    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(" + this.deadline + ")";
    }
}
