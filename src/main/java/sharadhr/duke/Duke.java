package sharadhr.duke;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Duke
{
    public static void main(String[] args) throws IOException
    {
        String logo = " ____        _        \n" 
                + "|  _ \\ _   _| | _____ \n" 
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n" 
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        // Buffered reader and writer for better performance over Scanner and System.out.println().
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // The ArrayList of inputs 
        ArrayList<String> inputs = new ArrayList<String>();

        // The input String
        String input;
        while (!(input = reader.readLine()).equals("bye"))
        {
            if (input.equals("list"))
            {
                // Print everything in the list, with a number
                int i = 1;
                for (String item : inputs)
                {
                    writer.append(String.format("%d\t%s%n", i++, item));
                    writer.flush();
                }
                continue;
            }

            // Add the String input to the ArrayList of inputs
            inputs.add(input);
            writer.write(String.format("added: %s%n", input));
            writer.flush();
        }
        writer.write("Goodbye, see you soon!");
        writer.flush();

        // Clean up and exit gracefully. 
        reader.close();
        writer.close();
        System.exit(0);
    }
}
