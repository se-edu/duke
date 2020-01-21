import java.util.HashMap;
public class CommandHub {

    //idea: Perhaps use dictionary to store the different events
    private static HashMap<String,UserCommand> commandList = new HashMap();

    CommandHub(){
    };

    public static void initCreator(){
        commandList.put("null",null);
        commandList.put("bye",new Bye());
        commandList.put("list",new List_Command());
    }

    private static String parseString(String userInput){
        userInput.toLowerCase();

        return userInput;
    }

    public static UserCommand FetchCommand(String userInput){
        String ID = parseString(userInput);
        if(commandList.containsKey(ID)) {
            return commandList.get(ID);
        }
        if(ID.contains("done")){
            String[] splited = ID.split(" ");
            return new Done_Command(Integer.parseInt(splited[1]));
        }
        else{
            return new Add_Command(userInput);
        }
    }}
