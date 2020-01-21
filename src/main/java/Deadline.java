public class Deadline extends Task {

    String date;

    public Deadline(String desc, int index, String date){
        super(desc, index);
        this.date = date;
    }

    @Override
    public String toString() {
        return index + "." + "[D]" + super.toString() + "(by: " + date + ")";
    }
}
