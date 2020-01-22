import java.util.HashMap;
/*
*  CommandHub is for creation and initialisation of all commands. Inclusive of setting up command specifics
*   ie. setting up task to be removed
*
* */


public class CommandHub {
    private static HashMap<String,UserCommand> commandList = new HashMap();

    CommandHub(){
    };

    public static void initCreator(){
        commandList.put("null",null);
        commandList.put("bye",new Bye_Command());
        commandList.put("list",new List_Command());
    }

    private static String[] parseString(String userInput){
        userInput.toLowerCase();
        String[] parsedCommand = userInput.split(" ", 2);
        return parsedCommand;
    }

    public static UserCommand FetchCommand(String userInput) throws DukeException{
        String parsedCommand[] = parseString(userInput);
        String ID = parsedCommand[0];
        String desc = "null";
        if(parsedCommand.length>1) {//check if exist second line
            desc = parsedCommand[1];
        }

        if(commandList.containsKey(ID)) { //gets generic commands
            return commandList.get(ID);
        }
        else if(ID.contains("done")){ //done command
            if(desc.equals("null")||desc.equals("")){
                throw new DukeException("Done with what? Your life is it?");
            }
            return new Done_Command(Integer.parseInt(desc));
        }
        else if(ID.contains("todo")||ID.contains("deadline")||ID.contains("event")){ //list add
            if(desc.equals("null")){
                throw new DukeException("BAKA! Your not suppose to leave "+ID+" field empty!");
            }
            return new Add_Command(ID, desc);
        }
        else if(ID.contains("delete")){
            if(desc.equals("null")||desc.equals("")){
                throw new DukeException("Delete yourself!");
            }
            return new Del_Command(Integer.parseInt(desc));
        }
        else{
            throw new DukeException("Hello? You stupid? Wrong command lah please!");
        }
    }}
