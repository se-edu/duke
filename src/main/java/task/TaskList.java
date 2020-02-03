package task;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> passedList) {
        this.list = passedList;
    }

    /**
     * Renews the existing task list.
     *
     * @param newList the new task list
     */
    public void renewList(ArrayList<Task> newList) {
        this.list = newList;
    }

    /**
     * Gets the ArrayList of Task of the current task list.
     *
     * @return an Array List of Task objects
     */
    public ArrayList<Task> getList() {
        return this.list;
    }

    /**
     * Adds a new task to the task list.
     *
     * @param addedTask the newly added Task
     */
    public void add(Task addedTask) {
        this.list.add(addedTask);
    }

    /**
     * Deletes a task from the task list.
     *
     * @param index the index of the task being deleted
     */
    public void delete(int index) {
        this.list.remove(index);
    }

    /**
     * Marks one task as done.
     *
     * @param index the index of the task being done
     */
    public void done(int index) {
        this.list.get(index).markAsDone();
    }
}
