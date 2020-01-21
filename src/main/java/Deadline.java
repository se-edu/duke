public class Deadline extends Task {

    String date;

    public Deadline(String desc, int index){
        super(desc, index);
        this.date = desc.split("/by ")[1];
    }

    @Override
    public String toString() {
        return index + "." + "[D]" + super.toString() + "(by: " + date + ")";
    }
}
