package duke.command;

import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * AddCommand inherits from the Command abstract class.
 * Executes the task in an orderly manner.
 */
public class AddCommand extends Command {
    private final Task task;
    private final String success = "Success";

    /**
     * Stores the task that needs to be added to the taskList later on.
     * @param task task that needs to be stored later.
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Additional isExit variable that enables for quick exit feature.
     * @param isExit if isExit is true the command will terminate the program after it executes.
     * @param task task that needs to be stored inside the taskList.
     */
    public AddCommand(Boolean isExit, Task task) {
        super(isExit);
        this.task = task;
    }

    /**
     * Add task to tasklist.
     * Updates task in storage.
     * Prints feedback to user.
     * @param taskList taskList used to update task.
     * @param ui Print feedback.
     * @param storage Save progress at txt file.
     * @return returns duke.command.CommandResult.
     */
    public CommandResult execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            taskList.addTask(this.task);
            storage.saveTask(taskList);
            ui.addTaskSuccess(this.task);
            return new CommandResult(success);
        } catch (Exception ex) {
            return new CommandResult(ex.getMessage());
        }
    }


}
