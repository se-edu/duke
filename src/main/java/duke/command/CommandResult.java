package duke.command;

/**
 * Command result that record if the execution is successful.
 * @author Lua Jia Zheng.
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
