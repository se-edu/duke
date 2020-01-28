import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadlines extends Task {
    private String date;
    private LocalDate date1;

    /**
     * Deadline that extends task and tracks date/time.
     * @param title title of the event.
     * @param index index of the event in the task tracker.
     * @param symbol Symbol D to signify Deadline events
     * @param date date and time in the form of strings
     */

    public Deadlines(String title,int index, Symbol symbol,String date) {
        super(title,index);
        this.symbol = "D";
        this.date = date;
        this.date1 = LocalDate.parse(date);
    }

    @Override
    public String toString() {
        String crosstick = "";
        if (this.done) {
            crosstick = "✓";
        } else {
            crosstick = "✗";
        }
        String dateFormatted = this.date1.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return String.format("[%s][%s] %s (by: %s)", this.symbol, crosstick, this.title, dateFormatted);
    }
}
