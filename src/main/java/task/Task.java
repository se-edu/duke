package task;

public class Task {

    private String name;
    private boolean isDone;

    public Task(String name){
        this.name = name;
        this.isDone = false;
    }

    public void markAsDone(){
        this.isDone = true;
    }

    public String toString(){
        String mark = "";
        if(this.isDone){
            mark = "[✓]";
        } else {
            mark = "[✗]";
        }
        return mark + " " + this.name;
    }

}
