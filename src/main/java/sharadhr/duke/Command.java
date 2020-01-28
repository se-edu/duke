package sharadhr.duke;

/**
 * A possible command to the Duke program.
 */
public enum Command
{
    TODO, DEADLINE, EVENT, 
    LIST, DONE, DELETE,
    BY, AT, ON, 
    EMPTY, INVALID, BYE;
    
    public static Command whichCommand(String input)
    {
        for (Command command : Command.values())
            if (input.equalsIgnoreCase(command.toString()))
                return command;
            else if (input.isBlank())
                return EMPTY;
        return INVALID;
    }
}
