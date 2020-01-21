public class Task {

    int index;
    String desc;
    boolean done;

    public Task ( String desc, int index ){
        this.index = index;
        this.desc = desc.split("/")[0].trim();
        this.done = false;
    }

    @Override
    public String toString() {

        String done = this.done?"Y": "N";

        return "[" + done + "] " + this.desc;
    }

    public void markAsDone(){
        this.done = true;
    }

}
