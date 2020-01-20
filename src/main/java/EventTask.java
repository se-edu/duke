public class EventTask extends Task {
    private String deadline;

    EventTask(String description, boolean isDone, String deadline) {
        super(description, isDone);
        this.deadline = deadline;
    }

    @Override
    EventTask completeTask() {
        return new EventTask(this.description, true, this.deadline);
    }

    @Override
    public String toString() {
        return "[E] [" + super.getStatusIcon() + "] " + this.description
                + " (" + this.deadline + ")";
    }
}