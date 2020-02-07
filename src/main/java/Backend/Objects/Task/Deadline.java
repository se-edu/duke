package Backend.Objects.Task;

import Backend.Parsers.DateParser;

public class Deadline extends Task {

    public Deadline( String desc, int index, DateParser date) {
        super( desc, index, date );
    }

    @Override
    public String toString() {
        return index + "." + "[D]" + super.toString() + " (by: " + date.getDateString() + ")";
    }
}
