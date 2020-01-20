package sharadhr.duke;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * 
 */
public class Duke
{
    // The list of Tasks
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    /**
     * 
     * @param task A task to be added to the list.
     * @return {@code true} if task was successfully added (as specified by {@link ArrayList#add})
     * @throws IOException
     */
    
    
    public static void main(String[] args) throws IOException
    {
        // Creates a task list.
        Task.createList();

        String logo = " ____        _        \n" 
                + "|  _ \\ _   _| | _____ \n" 
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n" 
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        // Buffered reader and writer for better performance over Scanner and System.out.println().
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // The input String
        String input;
        // The tokenised input
        String[] inputTokens;
        // A possible command to the application
        Command command;

        while (!(command = Command.whichCommand(
                Parser.getFirstToken((
                inputTokens = Parser.tokenise((input = reader.readLine()))))))
                .equals(Command.BYE))
        {
            switch (command)
            {
                case LIST:
                {
                    Task.listTasks();
                    break;
                }
                case DONE:
                {
                    Task.getTaskAtPosition(Integer.parseInt(inputTokens[1])).markComplete();
                    break;
                }
                case BYE:
                {
                    // Exit message
                    writer.write("Goodbye, see you soon!");
                    
                    // Clean up and exit gracefully. 
                    reader.close();
                    writer.close();
                    System.exit(0);
                }
                default:
                {
                    // Assume add for now
                    Task.addTask(new Task(input));
                }
            }
        }
    }
}
