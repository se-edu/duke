public class IncorrectCommand extends Command {
    private final String feedbackToUser;

    public IncorrectCommand(String feedbackToUser) {
        this.feedbackToUser = feedbackToUser;
    }

    public CommandResult execute(TaskList tasklist, Ui ui, Storage storage) {
        ui.showError(feedbackToUser);
        return new CommandResult(feedbackToUser);
    }

}
