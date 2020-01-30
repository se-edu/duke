package Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DukeDate {

    LocalDate date;
    String dateString;

    public DukeDate(LocalDate date){
        this.date = date;
        this.dateString = convertToString(date);
    }

    public DukeDate(String dateString){
        this.date = convertToDate(dateString);
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

}
