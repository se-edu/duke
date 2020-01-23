public class Deadline extends Task {
    String date;

    Deadline(String name, boolean isDone, String date) {
        super(name, isDone);
        this.date = date;
    }

    public static Deadline createDeadline(String name, boolean isDone, String date) {
        return new Deadline(name, isDone, date);
    }

    public String getDate() {
        return this.date;
    }

    @Override
    public Deadline complete() {
        return createDeadline(this.getName(), true, this.getDate());
    }

    @Override
    public String toString() {
        String taskString = super.toString();
        String result = "[D]" + taskString + " (by: " + date + ")";
        return result;
    }
}
