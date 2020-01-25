public class InvalidIndexException extends DukeException {

    String message;

    public InvalidIndexException(String message) {
        this.message = message;
    }

    public String toString() {
        return this.message;
    }
}