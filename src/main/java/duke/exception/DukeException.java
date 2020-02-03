package duke.exception;

public class DukeException extends Exception {

    public DukeException() {
        super("Invalid Instruction");
    }

    public DukeException(String message) {
        super(message);
    }
}
