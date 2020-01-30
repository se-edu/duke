public class Bot {

    TaskList taskList;

    public Bot(){
        this.taskList = new TaskList();
    }

    /**
     * switches response based on request
     * @param reqType request
     */
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

//    /**
//     * removes all non-alphabetical characters from a string.
//     * @param string
//     * @return string with no spaces
//     */
//    private static String removeNonAlphabetical(String string){
//
//        String _string = "";
//
//        char[] charArray = string.toCharArray();
//
//        for( char c : charArray ){
//
//            if( (int)c > 97 && (int)c < 123 ){
//                _string += c;
//            }
//        }
//
//        return _string;
//
//    }

    /**
     * parses input string to get first integer
     * @param string string to be parsed
     * @return first integer encountered
     */
    private static int getFirstInteger(String string) throws DukeException{

        int firstInteger = 0;

        char[] charArray = string.toCharArray();

        for( char c: charArray ){
            if((int)c > 47 && (int)c < 58){
                firstInteger = Character.getNumericValue(c);
            }
        }

        if( firstInteger < 1 ){
            throw new DukeException("Task index must be more than 0!");
        } else {
            return firstInteger;
        }

    }

    /**
     * parses command
     * @param string string to be parsed
     * @return first word of string
     */
    private static String getCommand(String string){

        return string.split(" ")[0];

    }

    /**
     * parses input string to retrieve task description
     * @param string - string to be parsed
     * @return task description
     * @throws DukeException
     */
    private static String getTaskDesc(String string) throws DukeException{
        try{

            int commandLength = getCommand(string).length();
            return string.substring(commandLength + 1).trim();

        } catch( StringIndexOutOfBoundsException e ){
            throw new DukeException("Task description cannot be empty!");
        }
    }

    /**
     * echos input string
     * @param string input string
     */
    public void echo(String string){
        System.out.println(string);
    }

    /**
     * switches on command and decides what is printed
     * @param req user input
     * @throws DukeException
     */
    public void res(String req) throws DukeException{

        String command = getCommand(req);
        int index;

        switch( command ) {
            case "list":
                System.out.println(taskList);
                break;
            case "done":
                index = getFirstInteger(req);
                taskList.markTask(index);
                break;
            case "delete":
                index = getFirstInteger(req);
                taskList.deleteTask(index);
                break;
            default:
                String taskDesc = getTaskDesc(req);
                taskList.addTask(taskDesc, command);
        }

    }

}









