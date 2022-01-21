package seedu.duke;

import java.util.ArrayList;

/**
 * TaskList is used to track all tasks taken in by Duke.
 */
public class TaskList {
    /**
     * An array that contains all tasks that will be added.
     */
    private final ArrayList<Task> tasks;

    /**
     * Constructor for TaskList with no parameters.
     */
     TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Creates a {@link TaskList} with attribute tasks being specified as a given {@link ArrayList}.
     * @param newTaskList is an {@link ArrayList} of {@link Task}.
     */
    TaskList(ArrayList<Task> newTaskList) {
        this.tasks = newTaskList;
    }

    /**
     * returns the number of tasks in the {@link ArrayList} of {@link Task}.
     * @return an integer specifying the number of tasks
     */
    int getNumberOfTasks() {
        return this.tasks.size();
    }

    /**
     * Used to print all tasks when command "list" is called in Duke.
     */
    void printTasks() {
        System.out.println("Here is your to-do:");
        for (int i = 0; i < this.getNumberOfTasks(); i++) {
            System.out.println(String
                    .format("%d . %s", i + 1, tasks.get(i).toString()));
        }
    }

    /**
     * Used to preserve immutability.
     * @return {@link ArrayList}, a copy of this
     */
    ArrayList<Task> copyTaskList() {
        return new ArrayList<Task>(this.tasks);
    }

    /**
     * Marks a task as done.
     * @param index where task to be marked is at in TaskList
     * @return TaskList with updated {@link ArrayList}
     */
    TaskList mark(int index) {
        try {
            Task taskToUpdate = this.tasks.get(index);
            if (taskToUpdate.isDone()) {
                System.out
                        .println("Oh hmm...you finished it already though...what a trooper!");
                return this;
            }
            Task newTask = taskToUpdate.changeTaskStatus(true);

            //create same size array since we are just adjusting values in the same array
            ArrayList<Task> newTasks = this.copyTaskList();
            newTasks.set(index, newTask);

            System.out.println(String
                    .format("Nice! I've marked this task as done: \n%s", newTask.toString()));

            return new TaskList(newTasks);
        } catch (IndexOutOfBoundsException e) {
            System.out
                    .println("Not so fast! I don't think that task exists! See for yourself");
            this.printTasks();
            return this;
        }
    }

    /**
     * Marks a task as undone.
     * @param index where the task to be unmarked is at in TaskList
     * @return TaskList with updated {@link ArrayList}
     */
    TaskList unmark(int index) {
        try {
            Task taskToUpdate = this.tasks.get(index);
            if (!taskToUpdate.isDone()) { //if task is already unmarked
                System.out
                        .println("It seems like you haven't marked it as done yet...");
                return this;
            }
            Task newTask = taskToUpdate.changeTaskStatus(false);
            ArrayList<Task> newTasks = this.copyTaskList();
            newTasks.set(index, newTask);

            System.out.println(String
                    .format("OK, I've marked this task as not done yet:\n %s", newTask.toString()));

            return new TaskList(newTasks);
        } catch (IndexOutOfBoundsException e) {
            System.out
                    .println("Not so fast! I don't think that task exists! See for yourself");
            this.printTasks();
            return this;
        }
    }

    /**
     * Adds tasks to TaskList.
     * @param task is the one to be added to TaskList
     * @return new TaskList with increased size to accomodate newTask
     */
    TaskList add(Task task) {
        //increase size of taskList by 1
        ArrayList<Task> newTasks = this.copyTaskList();
        newTasks.add(task);
        System.out.println(String
                .format("Got it, I've added this task: \n %s\nNow you have %d task in the list",
                        task.toString(),
                        this.getNumberOfTasks() + 1));
        return new TaskList(newTasks);
    }

    /**
     * Deletes task from TaskList.
     * @param index of task to be deleted from TaskList
     * @return new {@link TaskList} with specified task deleted
     */
    TaskList delete(int index) {
        //increase size of taskList by 1
        ArrayList<Task> updatedTasks = this.copyTaskList();
        Task taskToRemove = this.tasks.get(index);
        updatedTasks.remove(index);
        System.out.println(String
                .format("Got it, I've deleted this task: \n %s\nNow you have %d task in the list",
                        taskToRemove.toString(),
                        this.getNumberOfTasks() - 1));
        return new TaskList(updatedTasks);
    }
}
