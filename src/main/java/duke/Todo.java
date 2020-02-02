package duke;

/** Represnts a task of type todo
 */
public class Todo extends Task{
    private String by;

    /** Creates a task of type todo
     * with the specified description .
     * @param description The description of the task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * @return a string that represents the task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /** Prints the string representation of the
     * task that is to be saved in the file.
     * @return a string representation of the
     * task to be saved in the file.
     */
    @Override
    public String printToFile() {
        return "T" + super.printToFile();
    }
}
