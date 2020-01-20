package sharadhr.duke;

import java.util.stream.Stream;

/**
 * A utility class that parses inputs to the Duke chat bot.
 */
public class Parser
{
    /**
     * Trims and tokenises a {@link String} by any whitespace of arbitrary length: tab, newline, space.
     * @param input The input string to be tokenised
     * @return A {@link String}[] of tokens
     */
    public static String[] tokenise(String input)
    {
        return input.trim().split("\\s+");
    }

    /**
     * Returns the first token of a {@link String}[] of a tokenised input String
     * @param input The tokenised input
     * @return The <em>first</em> token in the input
     */
    public static String getFirstToken(String[] input)
    {
        return input[0];
    }
    
    /**
     * Returns the first token of an input {@link String}
     * 
     * @param input The input
     * @return The <em>first</em> token in the input
     */
    public static String getFirstToken(String input)
    {
        return getFirstToken(tokenise(input));
    }

    /**
     * Returns a {@link Stream} of tokens from some tokenised input.
     * @param input The tokenised input
     * @return 
     */
    public static Stream<String> tokenStream(String[] input)
    {
        return Stream.of(input);
    }
    
    /**
     * 
     * @param input
     * @return
     */
    public static Stream<String> tokenStream(String input)
    {
        return Stream.of(tokenise(input));
    }
}