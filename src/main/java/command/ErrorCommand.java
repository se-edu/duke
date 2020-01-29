package command;

import ui.TextUi;
import common.Storage;
import common.Message;
import exception.DukeException;
import task.*;

public class ErrorCommand extends Command{

    /**
     * Represents a wrong command which should be ignored with an error message.
     */
    public ErrorCommand(){
        super();
    }

    public void execute(TaskList tasks, TextUi textUi, Storage storage) throws DukeException {
        textUi.showError(Message.MESSAGE_INVALIDCOMMAND);
    }

    public boolean isExit(){
        return false;
    }

}
