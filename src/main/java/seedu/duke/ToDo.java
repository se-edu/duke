package seedu.duke;

public class ToDo extends Task {

    /**
     * used to construct a ToDo object.
     * @param taskName which specifies name of task
     */
    ToDo(String taskName) {
        super(taskName, false);
    }

    /**
     * used to construct a ToDo with a specified boolean.
     * @param oldToDo for a ToDo object
     * @param done to specify a boolean
     */
    ToDo(ToDo oldToDo, boolean done) {
        super(oldToDo.getTaskName(), done);
    }

    @Override
    public Task changeTaskStatus(boolean status) {
        return new ToDo(this, status);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
