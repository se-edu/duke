public class ToDoTask extends Task {
    ToDoTask(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T] [" + super.getStatusIcon() + "] " + this.description;
    }
}
