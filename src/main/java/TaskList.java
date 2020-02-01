import java.time.LocalDate;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTodo(String nextString, int counter) {
        Ui ui = new Ui();
        try {
            if (nextString.equals("todo")) {
                throw new DukeException(ui.showEmptyTaskMsg());
            }
            ui.showAddTaskMsg();
            String name = nextString.substring(5);
            Task task = new Todo(name);
            tasks.add(counter, task);
            counter++;
            System.out.println("  " + task.toString());
            ui.showCounterMsg(counter);
        } catch (DukeException ex) {
            ex.printStackTrace();
        }
    }

    public void addDeadline(String nextString, int counter){
        Ui ui = new Ui();
        try {
            if (nextString.equals("deadline")) {
                throw new DukeException(ui.showEmptyTaskMsg());
            } else if (!nextString.contains("/by")) {
                throw new DukeException(ui.showWrongFormat());
            }
            ui.showAddTaskMsg();

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
            System.out.println("  " + task.toString());
            ui.showCounterMsg(counter);
        } catch (DukeException ex) {
            ex.printStackTrace();
        }
    }

    public void addEvent(String nextString, int counter) {
        Ui ui = new Ui();
        try {
            if (nextString.equals("event")) {
                throw new DukeException(ui.showEmptyTaskMsg());
            } else if (!nextString.contains("/at")) {
                throw new DukeException(ui.showWrongFormat());
            }
            ui.showAddTaskMsg();
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
            System.out.println("  " + task.toString());
            ui.showCounterMsg(counter);
        } catch (DukeException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteTask(String nextString, int counter) {
        Ui ui = new Ui();
        try {
            if (nextString.equals("delete")) {
                throw new DukeException(ui.showNoMsgToDelete());
            }
            String[] temp = nextString.split(" ");
            int index = Integer.parseInt(temp[1]) - 1;
            ui.showRemoveTaskMsg();
            Task current = tasks.get(index);
            tasks.remove(index);
            System.out.println(current.toString());
            counter--;
            ui.showCounterMsg(counter);
        } catch (DukeException ex) {
            ex.printStackTrace();
        }
    }

    public void endTask(String nextString) {
        Ui ui = new Ui();
        ui.showDoneMsg();
        String[] temp = nextString.split(" ");
        int index = Integer.parseInt(temp[1]) - 1;
        Task current = tasks.get(index);
        current.isDone = true;
        System.out.println(current.toString());
    }

    public void listTasks() {
        Ui ui = new Ui();
        ui.showListMsg();
        for (Task t : tasks) {
            System.out.println((tasks.indexOf(t) + 1) + ". " + t.toString());
        }
    }
}
