public class Todo extends Task {
    Todo(String name, boolean isDone) {
        super(name, isDone);
    }

    public static Todo createTodo(String name, boolean isDone) {
        return new Todo(name, isDone);
    }

    @Override
    public Todo complete() {
        return createTodo(this.getName(), true);
    }

    @Override
    public String toString() {
        String taskString = super.toString();
        String result = "[T]" + taskString;
        return result;
    }
}

