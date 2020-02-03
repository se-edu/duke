package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

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

    public abstract CommandResult execute(TaskList taskList, Ui ui, Storage storage);
}
