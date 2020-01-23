public class Event extends Task{
    String at;
    public Event(String[] description) {
        super(description[0]);
        at = (description[1].split(" ", 2))[1];
    }

    @Override
    public String toString() {
        return "[E] " + super.toString() + "(at: " + at + ")";
    }
}
