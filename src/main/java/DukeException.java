public class DukeException extends Exception {

    protected String description;

    public DukeException(String e) {
        this.description = e;
    }

    public void print() {
        if (description.equals("todo")) {
            System.out.println("Please enter a task to be done.");
        } else if (description.equals("deadline")) {
            System.out.println("Please enter a date to complete this task by.");
        } else if (description.equals("event")) {
            System.out.println(("Please enter the date of the event."));
        } else {
            System.out.println("Your entry is not recognised. Please try again.");
        }
    }
}
