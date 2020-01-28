import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private String date;
    private LocalDate date1;
    
    /**
     * SubClass of Task that tracks date/time.
     * @param title Title of the event
     * @param index Index of the event.
     * @param symbol Symbol/enum E
     * @param date Date of the event scheduled.
     */
    public Event(String title,int index, Symbol symbol,String date) {
        super(title,index);
        this.symbol = "E";
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
        return String.format("[%s][%s] %s (at: %s)", this.symbol, crosstick, this.title, dateFormatted);
    }
}
