import java.util.Optional;

public class Parser {

    private String input;
    /**
     * Parser
     * Each input starts with a COMMAND, followed by the CONTENT and optionally, the DATE
     */
    public Parser( String input ){
        this.input = input;
    }

    /**
     * Gets command, first word of input string
     * @return command
     */
    public String getCommand(){
        return input.split(" ")[0].trim();
    }

    /**
     * Gets content, removes command and everything after slash
     * @return content
     */
    public String getContent(){

        String[] splitArray = input.split("/");

        if( splitArray.length < 2 ){
            return input.split(" ")[1].trim();
        } else {
            return input.substring( getCommand().length() + 1 ).split("/")[0].trim();
        }

    }

    /**
     * Gets dateString
     * @return dateString
     */
    public String getDateString(){

        String[] splitArray =  input.split("/");

        if (splitArray.length < 2){
            return "";
        } else {
            return splitArray[1].split(" ")[1].trim();
        }

    }

    public Optional<Integer> getContentAsInt(){

        Integer contentAsInt;

        try {
            contentAsInt = Integer.parseInt(String.valueOf(getContent()));
            return Optional.of(contentAsInt);
        } catch( NumberFormatException e ){
            return Optional.empty();
        }

    }

}
