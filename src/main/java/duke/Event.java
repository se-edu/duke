package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** Represents a task of type event.
 */
public class Event extends Task {
    private LocalDate dateTime;

    /** Creates a task of type event with the
     * specified description and the date of the event.
     * @param description The description of the task.
     * @param dateTime The date that the event occurs.
     */
    public Event(String description, LocalDate dateTime) {
        super(description);
        this.dateTime = dateTime;
    }

    /**
     * @return a string that represents the task.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + dateTime.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    /** Prints the string representation of the
     * task that is to be saved in the file.
     * @return a string representation of the
     * task to be saved in the file.
     */
    @Override
    public String printToFile() {
        return "E" + super.printToFile() + " - " + dateTime;
    }
}

