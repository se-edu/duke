public class InvalidEventException extends DukeException {

    String message;

    public InvalidEventException(String message) {
        this.message = message;
    }

    public String toString() {
        return this.message;
    }
}