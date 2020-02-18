package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * DisplayTaskCommand inherits Command.
 * Implements the abstract method execute.
 * @author Lua Jia Zheng.
 */
public class DisplayTaskCommand extends Command {
    static final String SUCCESS = "Success";

    public DisplayTaskCommand() {
    }

    public DisplayTaskCommand(Boolean isExit) {
        super(isExit);
    }

    /**
     * UI prints all the current task in task List.
     * @param tasks taskList used to retrieve current Tasks.
     * @param ui Prints feedback to user.
     * @param storage duke.storage.Storage not used.
     * @return Returns duke.command.CommandResult.
     */
    public CommandResult execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            tasks.sortTask();
            storage.saveTask(tasks);
            ui.printStoredTask(tasks);
            return new CommandResult(SUCCESS);
        } catch (Exception ex) {
            return new CommandResult(ex.getMessage());
        }
    }
}
