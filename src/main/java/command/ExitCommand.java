package command;

import common.Storage;
import ui.TextUi;
import exception.DukeException;
import task.*;

/**
 * Represents a command that terminates the program.
 */
public class ExitCommand extends Command{

    public ExitCommand(){
        super();
    }

    public void execute(TaskList tasks, TextUi textUi, Storage storage) throws DukeException {

    }

    public boolean isExit(){
        return true;
    }

}
