package exceptions;

public class WrongUsageException extends Exception {
    public WrongUsageException(String message) {
        super(message);
    }
}