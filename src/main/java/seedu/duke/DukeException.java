package seedu.duke;

/**
 * The commandNotFullException is used when no command words were used or invalid/misspelled ones were given
 */
class commandDoesNotExistException extends Exception {
    commandDoesNotExistException(String errorMessage) {
        super(errorMessage);
    }
}


/**
 * The noDateException is thrown when for commands like deadline or event, there is no slash so code cannot find the date
 */
class noDateException extends Exception {

    noDateException() {}
    noDateException(String errorMessage) {
        super(errorMessage);
    }
}

/**
 * The noTaskException is thrown when there is no task given after command todo
 */
class noTaskException extends Exception {

    noTaskException() {}

    noTaskException(String errorMessage) {
        super(errorMessage);
    }
}