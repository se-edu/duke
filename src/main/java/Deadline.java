public class Deadline extends Task {
    public Deadline(String description, String endTime) {
        super(description);
        this.time = endTime;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString();
    }
}
