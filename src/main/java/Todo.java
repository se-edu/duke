public class Todo extends Task {

    public Todo(String title,int index, Symbol symbol) {
        super(title,index);
        this.symbol = "T";
    }

    @Override
    public String toString() {
        String crosstick = "";
        if (this.done) {
            crosstick = "✓";
        } else {
            crosstick = "✗";
        }
        return String.format("[%s][%s] %s", this.symbol, crosstick, this.title);
    }
}
