public class List {
    /** Number of connections to this database */
    private String task;
    private boolean isDone;
    private static int totalTasks = 0;

    public List(String task) {
        setTask(task);
        this.isDone = false;
        totalTasks++;
        System.out.println("____________________________________________________________");
        System.out.println("added: " + task);
        System.out.println("____________________________________________________________");
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    public String getStatusIcon() {
        return (isDone ? "[\u2713]" : "[\u2718]"); //return tick or X symbols
    }

    public List() {
        this("");//set empty task
    }

    public static int getTotalTasks() {
        return totalTasks;
    }
}
