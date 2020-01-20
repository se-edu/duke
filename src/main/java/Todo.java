public class Todo extends Task {
    public Todo(String d){
        super(d);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
