package seedu.duke;

public class TaskList {
    private final Task[] tasks;
    private final int nextIndexToAddTo;
    private final int MAX_TASK_COUNT = 100;

    TaskList() {
        this.tasks = new Task[MAX_TASK_COUNT];
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

    void mark(int index) {
        if (index > this.nextIndexToAddTo - 1 || index < 0) {
            System.out.println("Not so fast! I don't think that task exists! See for yourself");
            this.printTasks();
        } else {
            Task taskToUpdate = this.tasks[index];
            Task newTask = taskToUpdate.completeTask();
            this.tasks[index] = newTask;
            System.out.println(String.format("Nice! I've marked this task as done:\n %s", newTask.toString()));
        }
    }

    void unmark(int index) {
        if (index > this.nextIndexToAddTo - 1 || index < 0) {
            System.out.println("Not so fast! I don't think that task exists! See for yourself");
            this.printTasks();
        } else {
            Task taskToUpdate = this.tasks[index];
            Task newTask = taskToUpdate.uncompleteTask();
            this.tasks[index] = newTask;
            System.out.println(String.format("OK, I've marked this task as not done yet:\n %s", newTask.toString()));
        }
    }

    void add(Task task) {
        this.tasks[nextIndexToAddTo++] = task;
    }

}
