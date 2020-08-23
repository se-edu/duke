public class Task{
    private final String task;
    private boolean done;
    public Task(String task){
        this.task = task;
        this.done = false;
    }

    public void done(){
        this.done = true;
    }

    public String toString(){
        return ((this.done) ? "[" + "\u2713"+"]" : "[" + "\u1003" + "]") + " " + this.task;
    }
}