public class CommandInvoker {

    private static boolean endProgram = false;
    CommandInvoker(){};
    CommandInvoker(UserCommand c){
        Invoke(c);
    }


    public void Invoke(UserCommand c){
        int ID = c.getID();
        c.reply();
        c.action();
    }

    public static void stop(){
        endProgram = true;
    }

    public static boolean checkOff(){
        return endProgram;
    }

}
