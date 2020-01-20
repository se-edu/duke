class ToDoTask extends Task {
    ToDoTask(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    ToDoTask completeTask() {
        return new ToDoTask(this.description, true);
    }

    @Override
    public String toString() {
        return "[D] [" + super.getStatusIcon() + "] "
                + this.description;
    }
}
