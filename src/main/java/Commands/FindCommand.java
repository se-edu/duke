package Commands;

import Database.MyList;
import Exceptions.DukeException;
import Resources.Task;

import java.util.ArrayList;

public class FindCommand extends UserCommand{
    private static ArrayList<Task> localList;
    private static String keyword;

    /**
     * Instantiates a new User command.
     * Set the ID
     *
     * @param str the keyword
     */
    FindCommand(String str){
        super(6);
        keyword = str;
    }

    public static void setKeyword(String str){
        keyword = str;
    }

    @Override
    public boolean action() throws DukeException {
        System.out.println(MyList.find(keyword));
        return true;
    }
}
