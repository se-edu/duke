public class DeadlineTask extends Task {
    private String deadline;

    DeadlineTask(String description, boolean isDone, String deadline) {
        super(description, isDone);
        this.deadline = deadline;
    }

    @Override
    DeadlineTask completeTask() {
        return new DeadlineTask(this.description, true, this.deadline);
    }

    @Override
    public String toString() {
        return "[D] [" + super.getStatusIcon() + "] " + this.description
                + " (" + this.deadline + ")";
    }
}