package parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class TimeFormatter {

    private String strDate;

    public TimeFormatter (String strDate){
        this.strDate = strDate.trim();
    }

    public boolean checkValidDateFormat(){
        if(this.strDate.trim().equals("")){
            return false;
        }
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            Date javaDate = sdFormat.parse(this.strDate);
            if(Integer.valueOf(this.strDate.substring(5,7)) > 12){
                return false;
            }
            return true;
        }
        /* Date format is invalid */
        catch (ParseException e)
        {
            return false;
        }
    }

    public String toDesiredFormat(){
        LocalDate localDate = LocalDate.parse(this.strDate);
        return localDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

    public String processDate(){
        if(!this.checkValidDateFormat()){
            return this.strDate;
        } else {
            return this.toDesiredFormat();
        }
    }

}
