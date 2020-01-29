public class Event extends Task {
    protected String dateTime;

    public Event(String description, String dateTime) {
        super(description);
        this.dateTime = dateTime;
        type = "E";
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + dateTime + ")";
    }

    @Override
    public String printToFile() {
        return super.printToFile() + " - " + dateTime;
    }
}

