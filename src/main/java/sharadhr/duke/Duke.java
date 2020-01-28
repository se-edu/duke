package sharadhr.duke;

import sharadhr.duke.exception.DukeException;
import sharadhr.duke.io.Input;
import sharadhr.duke.io.Output;

/**
 * 
 */
public class Duke
{
    static Input reader;
    static Output writer;

    /**
     * The program loop that runs whilst the user does not say 'bye'.
     */
    public static boolean programLoop()
    {
        boolean exitLoop = false;
        Command command;
        
        do {
            command = Command.whichCommand(reader.nextLine().getFirstToken());
            exitLoop = command.equals(Command.BYE);

            switch (command)
            {
                case TODO:
                    try
                    {
                        Task.addTask(new Todo(reader.inputWithoutFirstToken()));
                    }
                    catch (DukeException e)
                    {
                        System.err.println("todo detail cannot be empty.");
                    }
                    break;
                case DEADLINE:
                    Task.addTask(new Deadline(reader.getDetail(), reader.getTime()));
                    break;
                case EVENT:
                    Task.addTask(new Event(reader.getDetail(), reader.getTime()));
                    break;
                case LIST:
                    Task.listTasks();
                    break;
                case DONE:
                    Task.getTaskAtPosition(Integer.parseInt(reader.inputWithoutFirstToken())).markComplete();
                    break;
                case DELETE:
                    Task.deleteTaskAtPosition(Integer.parseInt(reader.inputWithoutFirstToken()));
                case EMPTY:
                    continue;
                case INVALID:
                    try
                    {
                        throw new DukeException();
                    }
                    catch (DukeException e)
                    {
                        writer.say("Invalid command; try again.");
                    }
                case BYE:
                    break;
                default:
                    break;
            }
            
        } while (!exitLoop);
        return exitLoop;
    }

    /**
     * Cleans up objects and quits the program by calling {@link System#exit(int)}.
     */
    public static void exit()
    {
        writer.sayGoodBye();

        reader.close();
        writer.close();

        System.exit(0);
    }
    
    public static void main(String[] args)
    {
        // Initialises I/O.
        reader = new Input();
        writer = new Output();

        // Greets the user.
        writer.sayHello();

        // Creates the task list.
        Task.createList();

        if (!programLoop()) exit();
    }
}
