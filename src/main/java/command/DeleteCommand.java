package command;

import common.Message;
import common.Storage;
import ui.TextUi;
import exception.DukeException;
import task.*;

public class DeleteCommand extends Command {

    protected int index;

    public DeleteCommand(int index){
        super();
        this.index = index - 1;
    }

    public void execute(TaskList tasks, TextUi textUi, Storage storage) throws DukeException {
        if(this.index >= tasks.getList().size() || this.index < 0){
            textUi.showError(Message.MESSAGE_INVALIDCOMMAND);
            return;
        }
        textUi.showDeletingTask(this.index, tasks);
        tasks.delete(this.index);
        storage.writeToFile(tasks.getList());

    }

    public boolean isExit(){
        return false;
    }

}
