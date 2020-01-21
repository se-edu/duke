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
     * gets first integer
     * @param string
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
     * @param string
     * @return first word of string
     */
    private static String getCommand(String string){

        return string.split(" ")[0];

    }

    private static String getTaskDesc(String string) throws DukeException{
        try{

            int commandLength = getCommand(string).length();
            return string.substring(commandLength + 1).trim();

        } catch( StringIndexOutOfBoundsException e ){
            throw new DukeException("Task description cannot be empty!");
        }
    }

    public void echo(String string){
        System.out.println(string);
    }

    public void res(String req) throws DukeException{

        String command = getCommand(req);

        try{
            switch( command ) {
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
        } catch( DukeException e ){
            throw e;
        }

    }

}









