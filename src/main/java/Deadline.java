import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Deadline extends Task {


    public Deadline(String desc, int index, LocalDate date){

        super(desc, index, Optional.of(date));

    }

    @Override
    public String toString() {
        return index + "." + "[D]" + super.toString() + "(by: " + getDateString(date) + ")";
    }
}
