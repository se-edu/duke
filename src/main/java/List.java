public class List {
    private String task;
    private static int totalTasks = 0;


    public List(String task) {
        setTask(task);
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

    //To add new task into list
    public static void addTasks(String task) {
        return;
        //List.tasks = task;
    }

    public List() {
        this("");//set empty task
    }

    public static int getTotalTasks() {
        return totalTasks;
    }
}
