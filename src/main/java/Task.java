public class Task {
    protected String description;
    protected boolean isDone;

    //Generator, in the main file must you "new" modifier to create the objects
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String getDescription() {
        return description;
    }

    public void markAsDone(){
        this.isDone = true;
    }

}