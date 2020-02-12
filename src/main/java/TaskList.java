import java.time.LocalDate;
import java.util.ArrayList;

/** Represents the list of tasks.
 */
public class TaskList {
    private ArrayList<Task> tasks;
    private int counter;

    /** Creates a list of tasks which takes in a list containing
     *     all the tasks that have been added or were already in the list
     *     and a counter that keeps track of the total number of tasks in the list.
     * @param tasks represents the list of tasks
     * @param counter represents the total number of tasks in the list.
     */
    public TaskList(ArrayList<Task> tasks, int counter) {
        this.tasks = tasks;
        this.counter = counter;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /** Adds a task of type 'Todo' to the list of tasks.
     * @param nextString is the command entered by the user. Must contain
     *     the keyword 'todo' and a description of the task
     */
    public String addTodo(String nextString, Storage storage) throws DukeException {
        Ui ui = new Ui();
        if (nextString.equals("todo")) {
            throw new DukeException(ui.showEmptyTaskMsg());
        }
        String name = nextString.substring(5);
        Task task = new Todo(name);
        tasks.add(counter, task);
        counter++;
        storage.save(tasks);
        return ui.showAddTaskMsg() + "\t" + task.toString() + "\n" + ui.showCounterMsg(counter);
    }

    /** Adds a task of type 'Deadline' to the list of tasks.
     * @param nextString is the command entered by the user. Must contain
     *     the keyword 'deadline', a description of the task and the deadline
     *     of the task.
     */
    public String addDeadline(String nextString, Storage storage) throws DukeException {
        Ui ui = new Ui();
        if (nextString.equals("deadline")) {
            throw new DukeException(ui.showEmptyTaskMsg());
        } else if (!nextString.contains("/by")) {
            throw new DukeException(ui.showWrongFormat());
        }

        String name = nextString.substring(9);
        String taskName = name.split(" /by ")[0];
        String dateTime = name.split(" /by ")[1];
        String[] tempDate = dateTime.split(" ");
        int day = Integer.parseInt(tempDate[0].split("/")[0]);
        int month = Integer.parseInt(tempDate[0].split("/")[1]);
        int year = Integer.parseInt(tempDate[0].split("/")[2]);
        LocalDate date = LocalDate.of(year, month, day);
        Task task = new Deadline(taskName, date);

        tasks.add(counter, task);
        counter++;

        storage.save(tasks);

        return ui.showAddTaskMsg() + "\t" + task.toString() + "\n" + ui.showCounterMsg(counter);
    }

    /** Adds a task of type 'Event' to the list of tasks.
     * @param nextString is the command entered by the user. Must contain
     *     the keyword 'event', a description of the task and the date
     *     of the task.
     */
    public String addEvent(String nextString, Storage storage) throws DukeException {
        Ui ui = new Ui();
        if (nextString.equals("event")) {
            throw new DukeException(ui.showEmptyTaskMsg());
        } else if (!nextString.contains("/at")) {
            throw new DukeException(ui.showWrongFormat());
        }
        String name = nextString.substring(5);

        String taskName = name.split(" /at ")[0];
        String dateTime = name.split(" /at ")[1];

        String[] tempDate = dateTime.split(" ");
        int day = Integer.parseInt(tempDate[0].split("/")[0]);
        int month = Integer.parseInt(tempDate[0].split("/")[1]);
        int year = Integer.parseInt(tempDate[0].split("/")[2]);
        LocalDate date = LocalDate.of(year, month, day);
        Task task = new Event(taskName, date);

        tasks.add(counter, task);
        counter++;
        storage.save(tasks);

        return ui.showAddTaskMsg() + "\t" + task.toString() + "\n" + ui.showCounterMsg(counter);
    }

    /** Deletes a task from the list of tasks, given the index of a task.
     * @param nextString is the command entered by the user. Must contain
     *     the keyword 'delete' and the index of the task to be deleted.
     */
    public String deleteTask(String nextString, Storage storage) throws DukeException {
        Ui ui = new Ui();
        if (nextString.equals("delete")) {
            throw new DukeException(ui.showNoMsgToDelete());
        }
        String[] temp = nextString.split(" ");
        int index = Integer.parseInt(temp[1]) - 1;
        Task current = tasks.get(index);
        tasks.remove(index);
        counter--;

        storage.save(tasks);
        return ui.showRemoveTaskMsg() + current.toString() + "\n" + ui.showCounterMsg(counter);
    }

    /** Marks a task in the list of tasks as complete, given the index of the task.
     * @param nextString is the command entered by the user. Must contain
     *     the keyword 'done' and the index of the task.
     */
    public String markComplete(String nextString, Storage storage) {
        Ui ui = new Ui();

        String[] temp = nextString.split(" ");
        int index = Integer.parseInt(temp[1]) - 1;
        Task current = tasks.get(index);
        current.setIsDone();

        storage.save(tasks);
        return ui.showDoneMsg() + current.toString();
    }

    /** Lists all the tasks in the list of tasks that contains the keyword
     *     as inputted by the user.
     * @param nextString is the command entered by the user. Must contain
     *     the keyword 'find' and the keyword that the user wishes to filter
     *     the list of tasks against.
     */
    public String findTask(String nextString) {
        Ui ui = new Ui();
        String[] temp = nextString.split(" ");
        String keyword = temp[1];
        String toPrint = ui.showFindTaskMsg();
        for (Task t: tasks) {
            if (t.getDescription().contains(keyword)) {
                toPrint = toPrint + (tasks.indexOf(t) + 1) + ". " + t.toString() + "\n";
            }
        }
        return toPrint;
    }

    /** Lists all the tasks in the list of tasks.
     */
    public String listTasks() {
        Ui ui = new Ui();
        String temp = ui.showListMsg();
        for (Task t : tasks) {
            temp = temp + (tasks.indexOf(t) + 1) + ". " + t.toString() + "\n";
        }
        return temp;
    }
}
