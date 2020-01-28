package exception;

import common.Message;

/**
 * exception.DukeException is a self-defined exception class that deals with Duke-specific exceptions
 */
public class DukeException extends Exception {

    public String str1;

    /**
     * This constructor builds a exception.DukeException instance with the warning message.
     *
     * @param str2
     */
    public DukeException(String str2) {
        this.str1 = str2;
    }

    /**
     * This method converts a exception.DukeException instance to a string.
     */
    public String toString() {
        return (Message.MESSAGE_LINE + "\n" + "     :( OOPS!!! " + this.str1 + "\n" + Message.MESSAGE_LINE);
    }
}
