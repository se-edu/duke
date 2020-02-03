package duke.command;

import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;

import duke.ui.Ui;

public class DoneCommand extends Command {
    private final int taskIndex;
    private final String success = "Success";

    public DoneCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    public DoneCommand(Boolean isExit, int taskIndex) {
        super(isExit);
        this.taskIndex = taskIndex;
    }

    /**
     * mark Task as Done and feedback to User.
     * @param taskList taskList used to fetch the task.
     * @param ui Prints feedback to User.
     * @param storage duke.storage.Storage update task to txt file.
     * @return Return duke.command.CommandResult.
     */
    public CommandResult execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            Task task = taskList.doneTask(taskIndex);
            ui.doneTask(task);
            storage.saveTask(taskList);
            return new CommandResult(success);
        } catch (Exception ex) {
            return new CommandResult(ex.getMessage());
        }
    }
}
