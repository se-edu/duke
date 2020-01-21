import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

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

    private static String getDate(String taskDesc, String splitBy) throws DukeException{
        try {
            return taskDesc.split(splitBy)[1];
        } catch ( IndexOutOfBoundsException e ){
            throw new DukeException(taskDesc.split(splitBy)[0] + " must have a date!");
        }
    }

    public void addTask(String taskDesc, String taskType) throws DukeException{

        try {
            int index = this.list.size() + 1;

            Task task;
            String date;

            switch( taskType ){
                case "event":
                    date = this.getDate(taskDesc, "/at ");
                    task = new Event(taskDesc, index, date);
                    break;
                case "deadline":
                    date = this.getDate(taskDesc, "/by ");
                    task = new Deadline(taskDesc, index, date);
                    break;
                default:
                    task = new Todo(taskDesc, index);
            }

            this.list.add(task);
            System.out.println(task.desc);
        } catch(DukeException e){
            throw e;
        }
    }

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
