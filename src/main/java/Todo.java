public class Todo extends Task {

    protected String taskSymbol = "T";

    public Todo (String description) {
        super (description);
    }

    @Override
    public String toString() {
        if (super.isDone) {
            return ("[" + taskSymbol + "][Done] " + super.description);
        } else {
            return ("[" + taskSymbol + "][Not Done] " + super.description);
        }
    }

}
