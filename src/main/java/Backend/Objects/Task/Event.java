package Backend.Objects.Task;

import Backend.Parsers.DateParser;

public class Event extends Task {

    public Event(String desc, int index, DateParser date){
        super(desc, index, date);
    }

    @Override
    public String toString() {
        return index + "." + "[E]" + super.toString() + " (at: " + date.getDateString() + ")";
    }

}
