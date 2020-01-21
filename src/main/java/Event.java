public class Event extends Task {

    String date;

    public Event(String desc, int index, String date){
        super(desc, index);
//        this.date = desc.split("/at ")[1];
        this.date = date;
    }

    @Override
    public String toString() {
        return index + "." + "[E]" + super.toString() + "(at: " + date + ")";
    }
}
