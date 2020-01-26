public class DukeException extends Exception {

    protected String description;

    public DukeException(String e) {
        this.description = e;
    }

    public void print() {
        String reply;

        switch (description) {
            case "no todo task":
                reply = "Please enter a task to be done.";
                break;
            case "no deadline date":
                reply = "Please enter a date to complete this task by.";
                break;
            case "no event date":
                reply = "Please enter the date of the event.";
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
            case "Unrecognized":
                reply = "Your entry is not recognised. Please try again.";
                break;
        }

        System.out.println(reply);
    }
}
