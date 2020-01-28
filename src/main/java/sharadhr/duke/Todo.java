package sharadhr.duke;

import sharadhr.duke.exception.DukeException;

/**
 * A To-Do; effectively the same as the inherited abstract class, {@link Task}.
 */
public class Todo extends Task
{
    /**
     * Creates a To-Do with some detail.
     * @param detail What is to be done
     */
    public Todo(String detail) throws DukeException
    {
        if (detail.isBlank())
        {
            throw new DukeException();
        }
        this.detail = detail;
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