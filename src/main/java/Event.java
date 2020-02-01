import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDate dateTime;
    protected String type;

    public Event(String description, LocalDate dateTime) {
        super(description);
        this.dateTime = dateTime;
        this.type = "E";
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (by: " + dateTime.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    @Override
    public String printToFile() {
        return super.printToFile() + " - " + dateTime;
    }
}

