public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        String checkbox = "[" + super.getStatusIcon() + "]";
        return "[T]" + checkbox + " " + super.toString();
    }
}