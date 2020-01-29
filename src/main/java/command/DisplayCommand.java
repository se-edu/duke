package command;

import common.Storage;
import task.*;
import exception.DukeException;
import ui.TextUi;

/**
 * Represents a command that displays the task list.
 */
public class DisplayCommand extends Command{

    public DisplayCommand(){
        super();
    }

    public void execute(TaskList tasks, TextUi textUi, Storage storage) throws DukeException {
        textUi.displayList(tasks, storage);
    }

    public boolean isExit(){
        return false;
    }

}