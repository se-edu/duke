public class DukeException extends Exception {

    protected String description;

    public DukeException(String e) {
        this.description = e;
    }

    public void print() {
        String reply;

        switch (description) {
            case "insufficient details":
                reply = "Please enter more details for this task.";
                break;
            case "done":
                reply = "Please indicate a task number to mark as done.";
                break;
            case "List size":
                reply = "This task number does not exist.";
                break;
            case "wrong format":
                reply = "Your entry is of an incorrect format. Please try again.";
                break;
            case "delete":
                reply = "Please indicate a task number to mark for deletion.";
                break;
            default:
                reply = "Your entry is not recognised. Please try again.";
                break;
        }

        System.out.println(reply);
    }
}
