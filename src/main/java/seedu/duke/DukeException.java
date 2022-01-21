package seedu.duke;

/**
 * The commandNotFullException is used when no command words were used or invalid/misspelled ones were given
 */
class noCommandException extends Exception {
    /**
     * parameterless constructor for noCommandException.
     */
    noCommandException() { }

    /**
     * A constructor for noCommandException.
     * @param errorMessage for more information about the error.
     */
    noCommandException(String errorMessage) {
        super(errorMessage);
    }
}


/**
 * The noDateException is thrown when for commands like deadline or event, there is no slash so code cannot find the date.
 */
class noDateException extends Exception {

    /**
     * parameterless constructor for noDateException.
     */
    noDateException() { }

    /**
     * a constructor for noDateException.
     * @param errorMessage for more information about the error.
     */
    noDateException(String errorMessage) {
        super(errorMessage);
    }
}

/**
 * The noTaskException is thrown when there is no task given after command todo.
 */
class noTaskException extends StringIndexOutOfBoundsException{

    /**
     * parameterless constructor for noTaskException.
     */
    noTaskException() { }

    /**
     * constructor for noTaskException.
     * @param errorMessage that tells us about the error
     */
    noTaskException(String errorMessage) {
        super(errorMessage);
    }
}