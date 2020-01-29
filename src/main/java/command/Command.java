package command;

import exception.DukeException;
import task.*;
import ui.TextUi;
import common.Storage;

public abstract class Command {
    abstract public void execute(TaskList tasks, TextUi textUi, Storage storage) throws DukeException;
    abstract public boolean isExit();
}
