package seedu.duke;

import java.util.Arrays;

/**
 * TaskList is used to track all tasks taken in by Duke.
 */
public class TaskList {
    /**
     * An array that contains all tasks that will be added.
     */
    private final Task[] tasks;
    /**
     * Keeps track of the next index in the task array to add to.
     */
    private final int nextIndexToAddTo;

    /**
     * Constructor for TaskList, with Task[] of size 1 to save space.
     * Task[] size will expand with add().
     */
    TaskList() {
        this.tasks = new Task[1];
        //create a task list of size 1 first and then expand as we add
        this.nextIndexToAddTo = 0;
    }

    /**
     * Overloaded constructor.
     * @param tasks is a Task[] with tasks
     * @param nextIndex specifies where the next task will be added in Task[]
     */
    TaskList(Task[] tasks, int nextIndex) {
        this.tasks = tasks;
        this.nextIndexToAddTo = nextIndex;
    }

    int getNumberOfTasks() {
        return this.tasks.length;
    }

    /**
     * Used to print all tasks in Task[] when command "list" is called in Duke.
     */
    void printTasks() {
        for (int i = 0; i < nextIndexToAddTo; i++) {
            System.out.println(String
                    .format("%d . %s", i + 1, this.tasks[i].toString()));
        }
    }

    /**
     * Used to preserve immutability.
     * @param size for size of array
     * @return Task[] of a specific size with this.tasks copied over
     */
    Task[] copyTaskList(int size) {
        return Arrays.copyOf(this.tasks, size);
    }

    /**
     * Marks a task as done.
     * @param index where task to be marked is at in TaskList
     * @return TaskList with updated Task[]
     */
    TaskList mark(int index) {
        if (index > this.nextIndexToAddTo - 1 || index < 0) {
            System.out
                    .println("Not so fast! I don't think that task exists! See for yourself");
            this.printTasks();
            return this;
        } else {
            Task taskToUpdate = this.tasks[index];
            if (taskToUpdate.isDone()) {
                System.out
                        .println("Oh hmm...you finished it already though...what a trooper!");
                return this;
            }
            Task newTask = taskToUpdate.changeTaskStatus(true);

            //create same size array since we are just adjusting values in the same array
            Task[] newTasks = this.copyTaskList(this.tasks.length);
            newTasks[index] = newTask;

            System.out.println(String
                    .format("Nice! I've marked this task as done: \n%s", newTask.toString()));

            return new TaskList(newTasks, this.nextIndexToAddTo);

        }
    }

    /**
     * Marks a task as undone.
     * @param index where the task to be unmarked is at in TaskList
     * @return TaskList with updated Task[]
     */
    TaskList unmark(int index) {
        if (index > this.nextIndexToAddTo - 1 || index < 0) {
            System.out.println("Not so fast! I don't think that task exists! See for yourself");
            this.printTasks();
            return this;
        } else {
            Task taskToUpdate = this.tasks[index];
            if (!taskToUpdate.isDone()) { //if task is already unmarked
                System.out
                        .println("It seems like you haven't marked it as done yet...");
                return this;
            }
            Task newTask = taskToUpdate.changeTaskStatus(false);
            Task[] newTasks = this.copyTaskList(this.tasks.length);
            newTasks[index] = newTask;

            System.out.println(String
                    .format("OK, I've marked this task as not done yet:\n %s", newTask.toString()));

            return new TaskList(newTasks, this.nextIndexToAddTo);
        }
    }

    /**
     * Adds tasks to TaskList.
     * @param task to be added to TaskList
     * @return new TaskList with increased size to accomodate newTask
     */
    TaskList add(Task task) {
        //increase size of taskList by 1
        Task[] newTasks = this.copyTaskList(this.tasks.length + 1);
        newTasks[nextIndexToAddTo] = task;
        System.out.println(String
                .format("Got it, I've added this task: \n %s\nNow you have %d task in the list",
                        task.toString(),
                        this.getNumberOfTasks()));
        return new TaskList(newTasks, this.nextIndexToAddTo + 1);
    }

}
