package command;

import ui.TextUi;
import common.Storage;
import exception.DukeException;
import task.*;

public class DeleteCommand extends Command {

    protected int index;

    public DeleteCommand(int index){
        super();
        this.index = index - 1;
    }

    public void execute(TaskList tasks, TextUi textUi, Storage storage) throws DukeException {
        textUi.showDeletingTask(this.index, tasks);
        tasks.delete(this.index);
        storage.writeToFile(tasks.getList());

    }

    public boolean isExit(){
        return false;
    }
}
