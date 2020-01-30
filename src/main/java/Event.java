import java.time.LocalDate;
import java.util.Optional;

public class Event extends Task {

    public Event(String desc, int index, LocalDate date){
        super(desc, index, Optional.of(date));
    }

    @Override
    public String toString() {
        return index + "." + "[E]" + super.toString() + "(at: " + getDateString(date) + ")";
    }
}
