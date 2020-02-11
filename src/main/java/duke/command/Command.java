package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Abstract class with a core feature "execute".
 */
public abstract class Command {
    private boolean isExit;

    public Command(boolean isExit) {
        this.isExit = isExit;
    }

    public Command() {
        this.isExit = false;
    }

    public boolean getIsExit() {
        return this.isExit;
    }

    /**
     * To be implemented by superclass.
     * Complete and execute the task/command.
     * @param taskList taskList used to store or retrieve data.
     * @param ui ui used to print output to the user.
     * @param storage storage used to store or load data from a txt file.
     * @return returns a CommandResult object that lets you know if you have successfully execute the command.
     */
    public abstract CommandResult execute(TaskList taskList, Ui ui, Storage storage);
}
