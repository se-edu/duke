package Backend.Parsers;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateParser {

    private LocalDate date;
    private String dateString;

    private static final String noonString = "12:00";
    private static final String eveningString = "19:00";

    public DateParser( LocalDate date ) {
        this.date = date;
        this.dateString = convertToString( date );
    }

    public DateParser( String dateString ) {
        this.date = convertToDate( dateString );
        this.dateString = dateString;
    }

    /**
     * converts String to LocalDate object
     * @param dateString
     * @return LocalDate object
     */
    public static LocalDate convertToDate(String dateString){
        return LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * converts LocalDate object to String
     * @param date LocalDate object
     * @return date string in format YYYY-MM-DD
     */
    public static String convertToString(LocalDate date){
        return date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
    }

    /**
     * getter for LocalDate object
     * @return LocalDate object
     */
    public LocalDate getDate(){
        return this.date;
    }

    /**
     * getter for datestring
     * @return dateString
     */
    public String getDateString(){
        return this.dateString;
    }

    /**
     * gets the timeOfDay enum depending on the LocalDateTime
     * @return enum timeOfDay
     */
    public static TimeOfDay getTimeOfDay(){

        String formatString = "yyyy-MM-dd HH:mm";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatString);

        LocalDateTime now = LocalDateTime.now();
        String nowString = now.format(formatter);
        String dateString = nowString.split(" ")[0];
        LocalDateTime noon = LocalDateTime.parse(dateString + " " + noonString, formatter);
        LocalDateTime night = LocalDateTime.parse( dateString + " " + eveningString, formatter);

        assert( noon.isBefore( night ));

        if( now.isBefore( noon )){
            return TimeOfDay.MORNING;
        } else if ( now.isAfter( night ) ){
            return TimeOfDay.NIGHT;
        } else {
            return TimeOfDay.AFTERNOON;
        }

    }

}
