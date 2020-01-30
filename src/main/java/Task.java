import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Optional;

public class Task {

    int index;
    String desc;
    boolean done;
    Optional<LocalDate> date;


    public Task ( String desc, int index, Optional<LocalDate> date ){
        this.index = index;
        this.desc = desc.split("/")[0].trim();
        this.done = false;
        this.date = date;
    }

    @Override
    public String toString() {

        String done = this.done?"Y": "N";

        return "[" + done + "] " + this.desc;
    }

    public static String getDateString(Optional<LocalDate> date){
        return date.map(localDate -> localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))).orElse("");
    }

    public void markAsDone(){
        this.done = true;
    }

}
