public class Event extends Task {

    protected String eventTime;
    protected String taskSymbol = "E";

    public Event (String description, String eventTime) {
        super(description);
        this.eventTime = eventTime;
    }

    public String getEventTime() {
        return this.eventTime;
    }
}
