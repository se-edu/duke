package duke;

import java.util.ArrayList;

/** Represents a parser that parses input string
 *    to determine what command is run.
 */
public class Parser {
    private int counter;
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
    public ArrayList<Task> parseCommand(String nextString, TaskList tasks) {
        Ui ui = new Ui();
        if (nextString.equals("list")) {
            tasks.listTasks();
        } else if (nextString.contains("done")) {
            tasks.markComplete(nextString);
        } else if (nextString.contains("find")) {
            tasks.findTask(nextString);
        } else if (nextString.contains("todo")) {
            tasks.addTodo(nextString);
            counter++;
        } else if (nextString.contains("deadline")) {
            tasks.addDeadline(nextString);
            counter++;
        } else if (nextString.contains("event")) {
            tasks.addEvent(nextString);
            counter++;
        } else if (nextString.contains("delete")) {
            tasks.deleteTask(nextString);
            counter--;
        } else {
            try {
                throw new DukeException(ui.showWrongFormat());
            } catch (DukeException e) {
                e.printStackTrace();
            }
        }
        return tasklist;
    }
}
