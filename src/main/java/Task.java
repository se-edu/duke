public class Task {

    private String Title ="";
    private String Description = "";
    private String Datedue = "";
    protected boolean isDone;

    public Task(String description) {
        this.Description = description;
        this.isDone = false;
    }

    public void markDone(){
        isDone = true;
    }
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }


    @Override
    public String toString() {
        return getStatusIcon() +" " +Description;
    }
}
