import java.util.ArrayList;

public class Parser {
    private ArrayList<Task> tasklist;

    public Parser(ArrayList<Task> tasklist) {
        this.tasklist = tasklist;
    }

    public ArrayList<Task> parseCommand(String nextString, TaskList tasks, int counter) {
        Ui ui = new Ui();
        if (nextString.equals("bye")) {
            ui.sayBye();
        } else if (nextString.equals("list")) {
            tasks.listTasks();
        } else if (nextString.contains("done")) {
            tasks.endTask(nextString);
        } else if (nextString.contains("todo")) {
            tasks.addTodo(nextString, counter);
        } else if (nextString.contains("deadline")) {
            tasks.addDeadline(nextString, counter);
        } else if (nextString.contains("event")) {
            tasks.addEvent(nextString, counter);
        } else if (nextString.contains("delete")) {
            tasks.deleteTask(nextString, counter);
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
