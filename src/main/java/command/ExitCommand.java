package command;

import ui.TextUi;
import common.Storage;
import exception.DukeException;
import task.*;

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
