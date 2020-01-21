public class Event extends Task {

    String date;

    public Event(String desc, int index){
        super(desc, index);
        this.date = desc.split("/at ")[1];
    }

    @Override
    public String toString() {
        return index + "." + "[E]" + super.toString() + "(at: " + date + ")";
    }
}
