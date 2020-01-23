public class Event extends Task{
    String at;
    public Event(String[] description) {
        super(description[0]);
        at = description[1];
    }

    @Override
    public String toString() {
        return "[D] " + super.toString() + "(at: " + at + ")";
    }
}
