public class InvalidRequestException extends Exception {
    public InvalidRequestException() {
        super("Oops! Sorry, I don't know what that means :(");
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
