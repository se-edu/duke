package seedu.duke.exceptions;

/**
 * The NoDateException is thrown when for commands like deadline or event, there is no slash so code cannot find the date.
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
