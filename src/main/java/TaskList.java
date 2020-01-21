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
        String str = "Here are the tasks in your list:\n";

        for( int i = 0; i < this.list.size(); i++ ){
            str = str + this.list.get(i);

            if( i < this.list.size() - 1){
                str = str + "\n";
            }
        }

        return str;
    }

    public void addTask(String taskDesc, String taskType){

        int index = this.list.size() + 1;

        Task task;

        switch( taskType ){
            case "event":
                task = new Event(taskDesc, index);
                break;
            case "deadline":
                task = new Deadline(taskDesc, index);
                break;
            default:
                task = new Todo(taskDesc, index);
        }

        this.list.add(task);
        System.out.println(task.desc);
    }

    public void markTask(int taskIndex){

        Task task = this.list.get(taskIndex - 1);

        task.markAsDone();

        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task);

    }


}
