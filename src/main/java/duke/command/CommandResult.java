package duke.command;

/**
 * Command result that record if the execution is successful.
 */
public class CommandResult {
    public final String feedbackToUser;

    public CommandResult(String feedbackToUser) {
        this.feedbackToUser = feedbackToUser;
    }

    public String toString() {
        return feedbackToUser;
    }
}
