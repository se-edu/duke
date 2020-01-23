public class Event extends Task {
    String date;

    Event(String name, boolean isDone, String date) {
        super(name, isDone);
        this.date = date;
    }

    public static Event createEvent(String name, boolean isDone, String date) {
        return new Event(name, isDone, date);
    }

    public String getDate() {
        return this.date;
    }

    @Override
    public Event complete() {
        return createEvent(this.getName(), true, this.getDate());
    }

    @Override
    public String toString() {
        String taskString = super.toString();
        String result = "[E]" + taskString + " (at: " + date + ")";
        return result;
    }
}
