import java.util.HashMap;
public class CommandCreator {

    //idea: Perhaps use dictionary to store the different events
    private static HashMap<String,UserCommand> commandList = new HashMap();

    CommandCreator(){
    };

    public static void initCreator(){
        commandList.put("null",null);
        commandList.put("bye",new Bye());
        commandList.put("list",new MyList());
    }

    public static UserCommand getCommand(String userInput){
        //ID = userInput.toLowerCase();
        if(commandList.containsKey(userInput)) {
            return commandList.get(userInput);
        }
        else{
            return new listHandler(userInput);
        }
    }}
