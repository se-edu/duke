package command;

import common.Message;
import task.*;
import exception.DukeException;
import common.Storage;
import ui.TextUi;

import java.util.ArrayList;

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