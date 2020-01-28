package sharadhr.duke.IO;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import sharadhr.duke.Task;

/**
 * A class to neatly format and write any output from the organiser chat bot,
 * Duke, to the standard output.
 */
public class Output
{
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static final String logo = 
            "\n ____        _        \n"
            + "|  _ \\ _   _| | _____ \n" 
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
            
    static void ioException()
    {
        System.err.println("I/O Exception occurred.");
    }
    
    /////////////////////////////////////////////////////////////////////////
    // Instance
    /////////////////////////////////////////////////////////////////////////
    
    public Output()
    {
        ;
    }
    
    void appendWithNewline(String string)
    {
        try
        {
            writer.append(string);
            writer.newLine();
        }
        catch (Exception e)
        {
            ioException();
        }
    }
    
    void appendAllWithNewline(String... strings)
    {
        Arrays.asList(strings).forEach(this::appendWithNewline);
    }
    
    public void addMessage(String message)
    {
        try
        {
            writer.append(message);
        }
        catch (Exception e)
        {
            ioException();
        }
    }

    public void say()
    {
        try
        {
            writer.flush();
        }
        catch (Exception e)
        {
            ioException();
        }
    }

    /**
     * Writes a specified message (given as a {@link String}) to the standard
     * output.
     * 
     * @param message The message to be written
     */
    public void sayMessage(String message)
    {
        try
        {
            this.appendWithNewline(message);
            writer.flush();
        }
        catch (Exception e)
        {
            ioException();
        }
    }
    
    /**
     * Writes multiple messages to the standard output. These messages are given as
     * a
     * comma-separated list.
     * 
     * @param messages The list of messages to be written to standard output
     */
    public void sayAll(String... messages)
    {
        try
        {
            appendAllWithNewline(messages);
            writer.flush();
        }
        catch (Exception e)
        {
            ioException();
        }
    }
    
    /**
     * Greets the user.
     */
    public void sayHello()
    {
        this.sayMessage("Hello, this is" + logo + "How can I help?");
    }
    
    /**
     * Bids the user farewell; should be called when program is exiting.
     */
    public void sayGoodBye()
    {
        this.sayMessage("Goodbye, then; see you soon!");
    }
    
    /**
     * Given a task, tells the user that the task was added to the task list,
     * formatted appropriately.
     * 
     * @param task The task that was added to the task list
     */
    public void sayTaskAdded(Task task)
    {
        this.sayAll("This task was added: ", task.toString());
    }
    
    /**
     * Given a task, tells the user that the task was marked complete, formatted
     * appropriately.
     * 
     * @param task The task that was marked complete
     */
    public void sayTaskMarkedComplete(Task task)
    {
        this.sayAll("This task has been marked done:", task.toString());
    }

    public void close()
    {
        try
        {
            writer.close();
        }
        catch (Exception e)
        {
            ioException();
        }
    }
}