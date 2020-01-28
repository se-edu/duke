package task;

import common.Storage;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private ArrayList<Task> list;

    public TaskList(){
        this.list = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> passedList){
        this.list = passedList;
    }

    public ArrayList<Task> getList(){
        return this.list;
    }

    public void add(Task addedTask){
        this.list.add(addedTask);
    }

    public void delete(int index){
        this.list.remove(index);
    }

    public void done(int index){
        this.list.get(index).markAsDone();
    }
}
