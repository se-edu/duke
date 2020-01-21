/**
 * DukeException is a self-defined exception class that deals with Duke-specific exceptions
 */
public class DukeException extends Exception {

    public static final String LINE = "    ____________________________________________________________";

    public String str1;

    /**
     * This constructor builds a DukeException instance with the warning message.
     * @param str2
     */
    public DukeException (String str2){
        this.str1 = str2;
    }

    /**
     * This method converts a DukeException instance to a string.
     */
    public String toString(){
        return (LINE + "\n" + "     :( OOPS!!! " + this.str1 + "\n" + LINE);
    }
}
