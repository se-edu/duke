public class Event extends Task {
    public Event(String description, String time) {
        super(description);
        this.time = time; // represents a time period
    }

    @Override
    public String toString() {
        return "[E]" + super.toString();
    }
}
