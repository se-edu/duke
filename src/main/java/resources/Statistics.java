package resources;

/**
 * Handles everything to do with statistics
 */
public class Statistics {

    /**
     * Adds a task that is finish into the list
     * Updates the current week
     *
     * @return String the task to add
     */
    public static String taskDone() {
        return TaskTracker.doneThisWeek();
    }

    /**
     * Adds a task that is finish into the list
     * Updates the current week
     *
     * @return String the task of things completed
     */
    public static String numDone() {
        return "You have completed" + TaskTracker.done() + " this week...";
    }

}
