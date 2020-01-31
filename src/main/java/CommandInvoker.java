/*
*  "UI"
* */

public class CommandInvoker {

    private static boolean endProgram = false;
    CommandInvoker(){};
    CommandInvoker(UserCommand c){
        Invoke(c);
    }


    public static void Invoke(UserCommand c){
        try {
            int ID = c.getID();
            c.action();
            c.reply();
        }
        catch(DukeException e){
            System.out.println(e.getMessage());
        }

    }

    public static void stop(){
        endProgram = true;
    }

    public static boolean checkOff(){
        return endProgram;
    }

}
