package seedu.duke;

public class Event extends Deadline {

    /**
     * creates a new Event.
     * @param taskName for name of task
     * @param date for data that includes start date and end date of task
     */
    Event(String taskName, String date) {
        super(taskName, date);
    }

    /**
     * creates a new Event object with specified boolean as attribute 'done'.
     * @param oldEvent to get information like task name more efficiently
     * @param status to provide a specified boolean for attribute 'done' in new event
     */
    Event(Event oldEvent, boolean status) {
        super(oldEvent, status);
    }

    /**
     * Returns a new task with specified boolean as the done attribute.
     * @param status that provides a specified boolean for the new task
     * @return new Task with updated 'done' attribute
     */
    @Override
    public Task changeTaskStatus(boolean status) {
        return new Event(this, status);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString().substring(3);
        //get rid of [D] in deadline substring
    }
}
