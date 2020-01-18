package sharadhr.duke;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Duke
{
    public static void main(String[] args) throws IOException
    {
        String logo = " ____        _        \n" + "|  _ \\ _   _| | _____ \n" + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n" + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        
        // Buffered reader and writer for better performance over Scanner and System.out.println().
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input;
        while (!(input = reader.readLine()).equals("bye"))
        {
            writer.write(input);
            writer.newLine();
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
