package sharadhr.duke;

/**
 * A To-Do; effectively the same as the inherited abstract class, {@link Task}.
 */
public class Todo extends Task
{
    /**
     * Creates a To-Do with some detail.
     * @param detail What is to be done
     */
    public Todo(String detail)
    {
        super(detail);
    }

    @Override
     public char getTaskTypeIcon()
    {
        return 'T';
    }
    
    @Override
    public String toString()
    {
        return String.format("[%c]%s", this.getTaskTypeIcon(), super.toString());
    }
}