import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class DateTimeHandler{
    public static LocalDateTime getLocalDateTime(String desc) throws DukeException{
        try {
            if (containsTime(desc)) {
                String splitted[] = desc.split(" ");
                return DateTime.getDateTime(splitted[0], splitted[1]);
            } else if (isValidDate(desc)) {
                return DateTime.getDate(desc);
            } else if (isValidTime(desc)) {
                return DateTime.getTime(desc);
            } else {
                throw new DukeException("Please input a proper date/time!");
            }
        }
        catch(DateTimeException e){
            throw new DukeException("Invalid date/time format");
        }
    }

    public static String printsLocalDateTime(LocalDateTime dateTime){
        if(dateTime == null){
            return "";
        }
        else if(dateTime.getHour() == 0 && dateTime.getMinute() == 0 &&dateTime.getNano() == 0){ //only date
            return printDate(dateTime);
        }
        else{
            return printDateAndTime(dateTime);
        }
    }

    //understands 2/12/2019 1800
    private static boolean containsTime(String desc){
        String pattern = "[0-9]{2}/[0-9]{2}/[0-9]{4} [0-9]{4}";
        return Pattern.matches(pattern, desc);
    }

    private static boolean isValidDate(String date){
        String pattern = "[0-9]{2}/[0-9]{2}/[0-9]{4}";
        return Pattern.matches(pattern, date);
    }

    private static boolean isValidTime(String time){
        String pattern = "[0-9]{4}";
        return Pattern.matches(pattern, time);
    }


    private static String printDateAndTime(LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy hh:mma");
        return dateTime.format(formatter);
    }

    private static String printDate(LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        return dateTime.format(formatter);
    }

    private static String printTime(LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        return dateTime.format(formatter);
    }

    public static String revertDateTime(String dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy hh:mma");
        DateTimeFormatter formatterSave = DateTimeFormatter.ofPattern("dd/MM/yyyy hhmm");
        return LocalDateTime.parse(dateTime, formatter).format(formatterSave);
    }

}
