package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** Represents a task of type deadline.
 */
public class Deadline extends Task {

    private LocalDate by;

    /** Creates a task of type deaedline with
     * the specified description and end date.
     * @param description The description of the task.
     * @param by The date that the task needs to be completed by.
     */
    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
    }

    /**
     * @return a string that represents the task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    /** Prints the string representation of the
     * task that is to be saved in the file.
     * @return a string representation of the
     * task to be saved in the file.
     */
    @Override
    public String printToFile() {
        return "D" + super.printToFile() + " - " + by;
    }
}