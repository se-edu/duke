package task;

import Parser.TimeFormatter;

public class Deadline extends Task {

    protected String by;

    public Deadline(String name, String by) {
        super(name);
        this.by = by;
    }

    public Deadline(String name, String by, boolean isDone) {
        super(name, isDone);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + new TimeFormatter(by).processDate() + ")";
    }

    public String toStringFileFormat(){
        return "D" + super.toStringFileFormat() + " | " + this.by;
    }
}
