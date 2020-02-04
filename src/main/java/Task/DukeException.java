package Task;

public class DukeException extends Exception {

    String err;

    public DukeException( String err ){
        super(err);
        this.err = err;
    }

    @Override
    public String toString() {

        return "I was unable to complete your request due to this exception, sir:\n " + this.err;

    }

}
