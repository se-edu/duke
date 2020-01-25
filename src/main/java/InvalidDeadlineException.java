public class InvalidDeadlineException extends DukeException {

    String message;

    public InvalidDeadlineException(String message) {
        this.message = message;
    }

    public String toString() {
        return this.message;
    }
}