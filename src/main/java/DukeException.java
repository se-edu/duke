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
        } else if (description.equals("done")) {
            System.out.println(("Please indicate a task number to mark as done."));
        } else if (description.equals("List size")) {
            System.out.println(("This task number does not exist."));
        } else if (description.equals("Format")) {
            System.out.println(("Your entry is of an incorrect format. Please try again."));
        } else if (description.equals("delete")) {
            System.out.println(("Please indicate a task number to mark for deletion."));
        } else {
            System.out.println("Your entry is not recognised. Please try again.");
        }
    }
}
