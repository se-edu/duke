package command;

import common.Storage;
import task.*;
import exception.DukeException;
import ui.TextUi;

public class DisplayCommand extends Command{

    public DisplayCommand(){
        super();
    }

    public void execute(TaskList tasks, TextUi textUi, Storage storage) throws DukeException {
        textUi.displayList(tasks);
    }



    public boolean isExit(){
        return false;
    }

}