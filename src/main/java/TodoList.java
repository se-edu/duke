import java.util.List;
import java.util.ArrayList;

public class TodoList {

    List<Task> list;

    public TodoList(){
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

    public void addTask(String taskDesc){
        Task task = new Task(taskDesc, this.list.size() + 1 );
        this.list.add(task);

        System.out.println("added: " + taskDesc);
    }

    public void markTask(int taskIndex){

        Task task = this.list.get(taskIndex - 1);

        task.markAsDone();

        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task);

    }


}
