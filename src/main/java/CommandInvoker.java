/*
*  "UI"
* */

/**
 * The type Command invoker.
 */
public class CommandInvoker {

    private static boolean isProgramEnd = false;

    /**
     * Instantiates a new Command invoker.
     */
    CommandInvoker(){};

    /**
     * Invoke userCommand
     *
     * @param c the userCommand
     */
    CommandInvoker(UserCommand c){
        Invoke(c);
    }


    /**
     * Invoke the Usercommand.
     *
     * @param c the UserCommand
     */
    public static void Invoke(UserCommand c){
        try {
            c.action();
            c.reply();
        }
        catch(DukeException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Stop the program. Sets the endProgram as true
     */
    public static void stop(){
        isProgramEnd = true;
    }

    /**
     * Check if program is quit
     *
     * @return the boolean
     */
    public static boolean checkOff(){
        return isProgramEnd;
    }

}
