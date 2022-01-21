package seedu.duke.exceptions;

/**
 * The NoDateException is thrown when for commands which requires dates.
 */
public class NoDateException extends Exception {

    /**
     * parameterless constructor for NoDateException.
     */
    public NoDateException() { }

    /**
     * a constructor for NoDateException.
     * @param errorMessage for more information about the error.
     */
    NoDateException(String errorMessage) {
        super(errorMessage);
    }
}
