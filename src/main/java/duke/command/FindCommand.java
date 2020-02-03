package duke.command;

import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

import java.util.TreeMap;

public class FindCommand extends Command {
    private String find;
    private final String success = "Success";

    public FindCommand(String find) {
        this.find = find;
    }

    /**
     * Find tasks with keyword.
     * Prints feedback to user.
     * @param taskList taskList used to find Task.
     * @param ui Print feedback.
     * @param storage not used.
     * @return returns duke.command.CommandResult.
     */
    public CommandResult execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            TreeMap<Integer, Task> foundTasks = taskList.findTask(find);
            ui.printFoundTask(foundTasks);
            return new CommandResult(success);
        } catch (Exception ex) {
            return new CommandResult(ex.getMessage());
        }
    }
}
