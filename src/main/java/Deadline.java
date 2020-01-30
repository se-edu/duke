public class Deadline extends Task {

    protected java.time.LocalDate by;

    public Deadline(String description, java.time.LocalDate by) {
        super(description);
        this.by = by;
        type = "D";
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String printToFile() {
        return super.printToFile() + " - " + by;
    }
}