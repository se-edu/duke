package seedu.duke;

import java.util.Arrays;

public class TaskList {
    private final Task[] tasks;
    private final int nextIndexToAddTo;

    TaskList() {
        this.tasks = new Task[1]; //create a task list of size 1 first and then expand as we add
        this.nextIndexToAddTo = 0;
    }

    TaskList(Task[] tasks, int nextIndexToAddTo) {
        this.tasks = tasks;
        this.nextIndexToAddTo = nextIndexToAddTo;
    }

    void printTasks() {
        for (int i = 0; i < nextIndexToAddTo; i++) {
            System.out.println(String.format("%d . %s",i + 1, this.tasks[i].toString()));
        }
    }

    Task[] copyTaskList(int size) {
        return Arrays.copyOf(this.tasks, size);
    }

    TaskList mark(int index) {
        if (index > this.nextIndexToAddTo - 1 || index < 0) {
            System.out.println("Not so fast! I don't think that task exists! See for yourself");
            this.printTasks();
            return this;
        } else {
            Task taskToUpdate = this.tasks[index];
            if (taskToUpdate.isDone()) {
                System.out.println("Oh hmm...you finished it already though...what a trooper!");
                return this;
            }
            Task newTask = taskToUpdate.completeTask();

            //create same size array since we are just adjusting values in the same array
            Task[] newTasks = this.copyTaskList(this.tasks.length);
            newTasks[index] = newTask;

            System.out.println(String.format("Nice! I've marked this task as done:\n %s", newTask.toString()));

            return new TaskList(newTasks, this.nextIndexToAddTo);

        }
    }

    TaskList unmark(int index) {
        if (index > this.nextIndexToAddTo - 1 || index < 0) {
            System.out.println("Not so fast! I don't think that task exists! See for yourself");
            this.printTasks();
            return this;
        } else {
            Task taskToUpdate = this.tasks[index];
            if (!taskToUpdate.isDone()) { //if task is already unmarked
                System.out.println("It seems like you haven't marked it as done yet...would you want me to mark it?");
                return this;
            }
            Task newTask = taskToUpdate.uncompleteTask();

            Task[] newTasks = this.copyTaskList(this.tasks.length);
            newTasks[index] = newTask;

            System.out.println(String.format("OK, I've marked this task as not done yet:\n %s", newTask.toString()));

            return new TaskList(newTasks, this.nextIndexToAddTo);
        }
    }

    TaskList add(Task task) {
        //increase size of taskList by 1
        Task[] newTasks = this.copyTaskList(this.tasks.length + 1);
        newTasks[nextIndexToAddTo] = task;
        return new TaskList(newTasks, this.nextIndexToAddTo + 1);
    }

}
