public class Task {

    private String Description = "";
    protected boolean isDone = false;

    public Task(String description) {
        this.Description = description;
    }

    protected void resetDesc(String desc){
        Description = desc;
    }

    public void markDone() throws DukeException{
        if(isDone){
            throw new DukeException(UI.getReply("doneAlready"));
        }
        isDone = true;
    }
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    @Override
    public String toString() {
        return "["+getStatusIcon() +"] " +Description;
    }
}
