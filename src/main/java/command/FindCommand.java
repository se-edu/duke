package command;

import common.Storage;
import task.*;
import exception.DukeException;
import ui.TextUi;

/**
 * Represents a command that finds matching items for the user.
 */
public class FindCommand extends Command{

    protected String searchingItem;

    public FindCommand(String item){
        super();
        this.searchingItem = item;
    }

    public void execute(TaskList tasks, TextUi textUi, Storage storage) throws DukeException {
        textUi.findList(tasks, searchingItem);
    }

    public boolean isExit(){
        return false;
    }

}