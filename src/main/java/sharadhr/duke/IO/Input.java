package sharadhr.duke.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Input
 */
public class Input
{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Pattern whitespace = Pattern.compile("\\s+");
    static Pattern slashCommands = Pattern.compile("(?i)\\/((at)|(by)|(on))");
    
    static String readline()
    {
        try
        {
            return reader.readLine();
        }
        catch (Exception e)
        {
            System.err.println("I/O exception occurred.");
            return "";
        }
    }
    
    /////////////////////////////////////////////////////////////////////////
    // Instance
    /////////////////////////////////////////////////////////////////////////
    
    protected String line;
    protected String[] tokens;
    
    public Input()
    {
    }
    
    /**
     * Gets the next line in the input stream, and stores it. Returns this object for method chaining.
     * 
     * @return this object, with the cursor advanced by one line.
     */
    public Input nextLine()
    {
        this.line = readline();
        this.tokens = whitespace.split(this.line.trim());
        return this;
    }
    
    public String[] getTokens()
    {
        this.tokens = this.tokens.length == 0 ? whitespace.split(this.line.trim()) : this.tokens;
        return this.tokens;
    }
    
    public Stream<String> getTokenStream()
    {
        return Stream.of(this.getTokens());
    }
    
    public String getFirstToken()
    {
        return this.tokens[0];
    }
    
    public String[] tokensWithoutFirst()
    {
        return this.getTokenStream().skip(1).toArray(String[]::new);
    }

    public String inputWithoutFirstToken()
    {
        return this.getTokenStream().skip(1).collect(Collectors.joining(""));
    }
    
    public String getDetail()
    {
        return Stream.of(this.tokens).skip(1).takeWhile(slashCommands.asMatchPredicate().negate())
                .collect(Collectors.joining(" "));
    }

    public String getTime() {
        return Stream.of(this.tokens).dropWhile(slashCommands.asMatchPredicate().negate()).skip(1)
                .collect(Collectors.joining(" "));
    }

    
    public void close()
    {
        try
        {
            reader.close();
        }
        catch (IOException e)
        {
            
            System.err.println("I/O Exception occurred.");
        }
    }
}