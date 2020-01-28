package command;

import common.Storage;
import task.*;
import exception.DukeException;
import ui.TextUi;

public class AddCommand extends Command{

    protected Task thisTask;

    public AddCommand(Task givenTask){
        super();
        this.thisTask = givenTask;
    }

    public void execute(TaskList tasks, TextUi textUi, Storage storage) throws DukeException {
        tasks.add(this.thisTask);
        storage.writeToFile(tasks.getList());
        textUi.showAddingTask(thisTask, tasks);
    }

    public boolean isExit(){
        return false;
    }

}
