import java.util.Optional;

public class Bot {

    TaskList taskList;

    public Bot(){
        this.taskList = new TaskList();
    }

    public void staticResponse(StaticReq reqType){
        switch( reqType ){
            case SAYGOODBYE:
                System.out.println("Catch you later!");
                break;
            case SAYHELLO:
                System.out.println("Hi! How may I help you?");
                break;
            default:
        }
    }

    /**
     * removes all non-alphabetical characters from a string.
     * @param string
     * @return string with no spaces
     */
    private static String removeNonAlphabetical(String string){

        String _string = "";

        char[] charArray = string.toCharArray();

        for( char c : charArray ){

            if( (int)c > 97 && (int)c < 123 ){
                _string += c;
            }
        }

        return _string;

    }

    /**
     * gets first integer
     * @param string
     * @return first integer encountered
     */
    private static int getFirstInteger(String string){

        char[] charArray = string.toCharArray();

        for( char c: charArray ){
            if((int)c > 47 && (int)c < 58){
                return Character.getNumericValue(c);
            }
        }

        return 0;

    }

    /**
     * parses command
     * @param string
     * @return first word of string
     */
    private static String getCommand(String string){

        return string.split(" ")[0];

    }

    private static String getTaskDesc(String string){
        int commandLength = getCommand(string).length();

        return string.substring(commandLength + 1).trim();
    }

    public void echo(String string){
        System.out.println(string);
    }

    public void res(String req){

        String command = getCommand(req);

        switch( command ){
            case "list":
                System.out.println(taskList);
                break;
            case "done":
                int index = getFirstInteger(req);
                taskList.markTask(index);
                break;
            default:
                String taskDesc = getTaskDesc(req);
                taskList.addTask(taskDesc, command);
        }


    }

}









