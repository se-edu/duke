public class Deadline extends Task {
    String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        String checkbox = "[" + super.getStatusIcon() + "]";
        return "[D]" + checkbox + " " + super.toString() + " (by: " + by + ")";
    }
}