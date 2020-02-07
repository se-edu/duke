package Backend.Exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeParseException;

public class DukeException extends Exception {

    String errorMsg;
    Exception e;

    public DukeException( Exception e ){

        String errorMsg = getErrorMsg();

        this.e = e;
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {

        return "I was unable to complete your request due to this exception, sir:\n " + errorMsg;

    }

    public String getErrorMsg(){

        if( e instanceof NullPointerException ){
            return "Please say smth la";
        } else if( e instanceof StringIndexOutOfBoundsException ) {
            return "Index not found";
        } else if( e instanceof  NumberFormatException ){
            return "Could not format this number";
        } else if( e instanceof IndexOutOfBoundsException ){
            return "Weird String";
        } else if( e instanceof DateTimeParseException ){
            return "Weird date";
        } else if( e instanceof FileNotFoundException ){
            return "File not found";
        } else if( e instanceof IOException){
            return "Error with input output";
        } else {
            return "Something went wrong and I'm not sure what";
        }

    }

}
