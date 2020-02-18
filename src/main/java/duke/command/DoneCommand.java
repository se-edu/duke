package duke.command;

import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;

import duke.ui.Ui;

/**
 * DoneCommand that inherits from the Command Class.
 * Implements abstract method execute.
 * @author Lua Jia Zheng.
 */
public class DoneCommand extends Command {
    private final int taskIndex;
    static final String SUCCESS = "Success";

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
            taskList.updateList(storage);
            Task task = taskList.doneTask(taskIndex);
            ui.doneTask(task);
            storage.saveTask(taskList);
            return new CommandResult(SUCCESS);
        } catch (Exception ex) {
            return new CommandResult(ex.getMessage());
        }
    }
}
