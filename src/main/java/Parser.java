import javafx.application.Platform;

import java.util.ArrayList;

/** Represents a parser that parses input string
 *    to determine what command is run.
 */
public class Parser {
    private static int counter;
    private ArrayList<Task> tasklist;

    /** Creates a parser object which takes in an arraylist
     *     of tasks which can be modified based on the command
     *     entered and a counter that keeps track of the number
     *     of tasks in the arraylist.
     * @param tasklist is the list of tasks in the file
     * @param counter is the total number of tasks in the file
     */
    public Parser(ArrayList<Task> tasklist, int counter) {
        this.tasklist = tasklist;
        this.counter = tasklist.size();
    }

    /** Filters through the list of valid commands that can be entered to
     *    modify the list of tasks and chooses the right command.
     * @param nextString is the command entered by the user and usually
     *     contains a command and some times a description of the task.
     * @param tasks is the current list of tasks before the modification
     * @return the arraylist of tasks after the modfication
     */
    public static String parseCommand(String nextString, TaskList tasks, Storage storage) throws DukeException {
        Ui ui = new Ui();
        if (nextString.equals("bye")) {
            Platform.exit();
        }else if (nextString.equals("list")) {
            return tasks.listTasks();
        } else if (nextString.contains("done")) {
            return tasks.markComplete(nextString, storage);
        } else if (nextString.contains("find")) {
            return tasks.findTask(nextString);
        } else if (nextString.contains("todo")) {
            counter++;
            return tasks.addTodo(nextString, storage);
        } else if (nextString.contains("deadline")) {
            counter++;
            return tasks.addDeadline(nextString, storage);
        } else if (nextString.contains("event")) {
            counter++;
            return tasks.addEvent(nextString, storage);
        } else if (nextString.contains("delete")) {
            counter--;
            return tasks.deleteTask(nextString, storage);
        } else {
            try {
                throw new DukeException(ui.showWrongFormat());
            } catch (DukeException e) {
                e.printStackTrace();
            }
        }
        return ui.showErrorMsg();
    }
}
