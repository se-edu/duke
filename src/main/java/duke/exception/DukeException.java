package duke.exception;

/**
 * DukeException inherits Exception class.
 * Handles all exceptions that involves Duke.
 */
public class DukeException extends Exception {

    public DukeException() {
        super("Invalid Instruction");
    }

    public DukeException(String message) {
        super(message);
    }
}
