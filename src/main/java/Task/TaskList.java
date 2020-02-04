package Task;

import Utils.Parser;
import Utils.Storage;

import java.time.format.DateTimeParseException;

import java.util.List;
import java.util.ArrayList;

public class TaskList {

    public List<Task> list;

    public TaskList(){
        this.list = new ArrayList<>();
    }

    public TaskList(String data){
        this.list = new ArrayList<>();
        restoreFromExisting(data);
    }


    private void restoreFromExisting(String data){

        String[] dataArray = data.split("\n");

        int i = 1;
        for( String line : dataArray ){
            Task task = Parser.parseTask(line, i);
            list.add(task);
            i++;
        }

    }

    private void saveList() throws DukeException {

        String data = "";

        for ( Task task : this.list ){
            data += task.toString() + "\n";
        }

        Storage.writeToFile(data);

    }

    public String printTasks(){

        String res = "";

        if( this.list.size() == 0 ){
            res = "You have no tasks in your list.";
        } else {

            for( Task task: list ){
                res += task.toString() + "\n";
            }

        }

        return res;
    }

    public String printTasksOn(String req) throws DukeException {

        try {

            String res = "";

            Parser parser = new Parser(req);
            DukeDate date = new DukeDate(parser.getDateString());

            res += "Here are your tasks for " + date.getDateString();

            for( Task task: list ){
                if(task.date != null && task.date.getDateString().equals(date.getDateString())){
                    res += task.toString() + "\n";
                }
            }

            return res;

        } catch (DateTimeParseException e){
            throw new DukeException("Date must be in the form YYYY-MM-DD!");
        }

    }

    /**
     * deletes task
     * @param taskIndex index of task to be deleted
     * @throws DukeException if no task found for index
     */
    public String deleteTask(int taskIndex) throws DukeException {
        try {

            String res = "";

            Task task = list.get(taskIndex - 1);

            res += "Noted. I've removed this task:\n";
            res += task.toString() + "\n";
            this.list.remove(task);
            this.saveList();

            res += "\nNow you have " + list.size() + "task(s) in the list";

            return res;

        } catch ( IndexOutOfBoundsException e){
            throw new DukeException("No task found for index " + taskIndex + "!");
        }
    }

    /**
     * adds task to list
     * @param req user input
     * @throws DukeException if no date
     */
    public String addTask(String req) throws DukeException {

        String res = "";

        Parser parser = new Parser(req);

        int index = this.list.size() + 1;

        Task task;

        String command = parser.getCommand();
        String content = parser.getContent();

        switch( command ){
            case "event":
                DukeDate date = new DukeDate(parser.getDateString());
                task = new Event(content, index, date);
                break;
            case "deadline":
                date = new DukeDate(parser.getDateString());
                task = new Deadline(content, index, date);
                break;
            default:
                task = new Todo(content, index);
        }

        this.list.add(task);
        this.saveList();
        res += task.content;

        return res;
    }

    /**
     * marks task as done
     * @param taskIndex index of task to be marked as done
     * @throws DukeException if index out of bounds
     */
    public String markTask(int taskIndex) throws DukeException {

        try {

            String res = "";

            Task task = this.list.get(taskIndex - 1);

            task.markAsDone();

            res += "Nice! I've marked this task as done:";
            res += task.toString();

            saveList();

            return res;

        } catch( IndexOutOfBoundsException e){
            throw new DukeException("Task.Task Index is invalid");
        }


    }


}
