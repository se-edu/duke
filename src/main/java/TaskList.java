import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import java.io.File;
import java.io.IOException;

public class TaskList {

    List<Task> list;

    public TaskList(){
        this.list = new ArrayList<>();
    }

    @Override
    public String toString() {

        if( this.list.size() == 0 ){
            return "You have no tasks in your list.";
        }

        String str = "Here are the tasks in your list:\n";

        for( int i = 0; i < this.list.size(); i++ ){
            str = str + this.list.get(i);

            if( i < this.list.size() - 1){
                str = str + "\n";
            }
        }

        return str;
    }


    /**
     * parses date from task description
     * @param taskDesc task description
     * @param splitBy substring before date to be parsed
     * @return date
     * @throws DukeException if no date
     */
    private static LocalDate getDate(String taskDesc, String splitBy) throws DukeException{
        try {

            String dateString = taskDesc.split(splitBy)[1];

            try {
                return LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e){
                throw new DukeException("Date must be in the form YYYY-MM-DD!");
            }


        } catch ( IndexOutOfBoundsException e ){
            throw new DukeException(taskDesc.split(splitBy)[0] + " must have a date!");
        }
    }

    private void saveList() throws DukeException{

        String dirname = "./data";
        String pathname = dirname + "/duke.txt";

        //make directory
        File dir = new File(dirname);
        dir.mkdir();

        //write to file
        File saveFile = new File(pathname);
        FileWriter fileWriter = null;

        try {

            fileWriter = new FileWriter(saveFile);
            fileWriter.write("SAVED TASKS\n\n");

            for ( Task task : this.list ){
                fileWriter.write(task.toString() + "\n");
            }

        } catch (IOException e) {
            throw new DukeException("Error writing to file. Your changes were not saved.");
        } finally {
            try {
                fileWriter.close();
            } catch ( IOException e ) {
                throw new DukeException("Error closing file");
            }
        }

    }

    public void printTasksOn(String command) throws DukeException {

        String dateString = command.split(" ")[1];

        try {
            LocalDate date = LocalDate.parse(dateString);

            System.out.println("Here are your tasks for " + Task.getDateString(Optional.of(date)));

            for( Task task: list ){
                if( task.date.isPresent() && task.date.get().equals(date) ){
                    System.out.println(task);
                }
            }

        } catch (DateTimeParseException e){
            throw new DukeException("Date must be in the form YYYY-MM-DD!");
        }

    }

    /**
     * deletes task
     * @param taskIndex index of task to be deleted
     * @throws DukeException if no task found for index
     */
    public void deleteTask(int taskIndex) throws DukeException{
        try {

            Task task = list.get(taskIndex - 1);

            System.out.println("Noted. I've removed this task:");
            System.out.println(task);
            this.list.remove(task);

            System.out.println("\nNow you have " + list.size() + "task(s) in the list");

        } catch ( IndexOutOfBoundsException e){
            throw new DukeException("No task found for index " + taskIndex + "!");
        }
    }

    /**
     * adds task to list
     * @param taskDesc task description
     * @param taskType type of task - event, deadline, todo (optional)
     * @throws DukeException if no date
     */
    public void addTask(String taskDesc, String taskType) throws DukeException{

        int index = this.list.size() + 1;

        Task task;
        LocalDate date;

        switch( taskType ){
            case "event":
                date = getDate(taskDesc, "/at ");
                task = new Event(taskDesc, index, date);
                break;
            case "deadline":
                date = getDate(taskDesc, "/by ");
                task = new Deadline(taskDesc, index, date);
                break;
            default:
                task = new Todo(taskDesc, index);
        }

        this.list.add(task);
        this.saveList();
        System.out.println(task.desc);
    }

    /**
     * marks task as done
     * @param taskIndex index of task to be marked as done
     * @throws DukeException if index out of bounds
     */
    public void markTask(int taskIndex) throws DukeException{

        try {
            Task task = this.list.get(taskIndex - 1);

            task.markAsDone();

            System.out.println("Nice! I've marked this task as done:");
            System.out.println(task);
        } catch( IndexOutOfBoundsException e){
            throw new DukeException("Task Index is invalid");
        }


    }


}
