public class DukeException extends Exception {


    public DukeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        String out = Duke.line + "\n" + Duke.space + super.getMessage() + "\n" + Duke.line;
        return out;
    }
}
