public class Deadline extends Task {
    String due;
    public Deadline(String[] description) {
        super(description[0]);
        due = description[1];
    }

    @Override
    public String toString() {
        return "[D] " + super.toString() + "(by: " + due + ")";
    }
}
