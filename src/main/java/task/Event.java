package task;

public class Event extends Task {

    protected String duration;

    public Event(String name, String duration) {
        super(name);
        this.duration = duration;
    }

    public Event(String name, String duration, boolean isDone) {
        super(name, isDone);
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + duration + ")";
    }

    public String toStringFileFormat(){
        return "E" + super.toStringFileFormat() + " | " + this.duration;
    }
}
