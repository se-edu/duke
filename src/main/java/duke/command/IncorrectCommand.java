package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * IncorrectCommand class inherits from Command class.
 * Implements abstract method execute.
 */
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
