package Task;

public class Task {

    public String content;
    public DukeDate date;
    int index;
    boolean done;


    public Task ( String content, int index, DukeDate date ) {
        this.content = content;
        this.date = date;
        this.index = index;
        this.done = false;
    }

    public Task( String content, int index ) {
        this.index = index;
        this.content = content;
        this.done = false;
    }

    @Override
    public String toString() {

        String done = this.done?"Y": "N";

        return "[" + done + "] " + this.content;
    }

    /**
     * marks task as done
     */
    public void markAsDone(){
        this.done = true;
    }

}
