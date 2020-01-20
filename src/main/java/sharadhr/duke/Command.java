package sharadhr.duke;

public enum Command
{
    LIST, DONE, BYE, EMPTY;
    
    public static Command whichCommand(String input)
    {
        for (Command command : Command.values())
            if (input.equalsIgnoreCase(command.toString()))
                return command;
            
        return EMPTY;
    }
}
