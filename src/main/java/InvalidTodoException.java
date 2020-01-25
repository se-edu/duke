public class InvalidTodoException extends DukeException {

    public String toString() {
        return "OOPS! Description of Todo cannot be empty.";
    }
}