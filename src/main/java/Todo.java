public class Todo extends Task {

    public Todo(String desc, int index){
        super(desc, index, null);
    }

    @Override
    public String toString() {
        return index + "." +"[T]" + super.toString();
    }
}
