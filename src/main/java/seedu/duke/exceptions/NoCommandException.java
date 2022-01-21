package seedu.duke.exceptions;

/**
 * The commandNotFullException is used when no command words were used or invalid/misspelled ones were given.
 */
public class NoCommandException extends Exception {
    /**
     * parameterless constructor for NoCommandException.
     */
    public NoCommandException() {
    }

    /**
     * A constructor for NoCommandException.
     * @param errorMessage for more information about the error.
     */
    NoCommandException(String errorMessage) {
        super(errorMessage);
    }
}
