public class CommandResult {
    public final String feedbackToUser;

    public CommandResult(String feedbackToUser) {
        this.feedbackToUser = feedbackToUser;
    }

    public String toString() {
        return feedbackToUser;
    }
}
