public class Task {

    int index;
    String desc;
    boolean done;

    public Task ( String desc, int index ){
        this.index = index;
        this.desc = desc;
        this.done = false;
    }

    @Override
    public String toString() {

        String checkbox = this.done?"COMPLETE": "INCOMPLETE";

        return index + ". " + this.desc;
    }
}
