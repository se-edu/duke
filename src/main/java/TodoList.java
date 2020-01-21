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
            str = str + this.list.get(i) + "\n";
        }

        return str;
    }

    public void addTask(String taskDesc){
        Task task = new Task(taskDesc, this.list.size() + 1 );
        this.list.add(task);

        System.out.println("added: " + taskDesc);
    }


}
