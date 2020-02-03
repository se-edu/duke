package duke;

import java.util.ArrayList;

public class Parser {
    private int counter;
    private ArrayList<Task> tasklist;

    public Parser(ArrayList<Task> tasklist, int counter) {
        this.tasklist = tasklist;
        this.counter = tasklist.size();
    }

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
