package task;

public class Task {

    protected String name;
    protected boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public Task(String name, boolean isDone){
        this.name = name;
        this.isDone = isDone;
    }

    /**
     * This method marks the isDone status of the object as true.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    public String toString() {
        String mark = "";
        if (this.isDone) {
            mark = "[✓]";
        } else {
            mark = "[✗]";
        }
        return mark + " " + this.name;
    }

    public String toStringFileFormat(){
        int num = -1;
        if(isDone){
            num = 1;
        } else {
            num = 0;
        }
        return " | " + num + " | " + this.name;
    }

}
