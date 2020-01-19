import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("I am a very angry bot and I hate you");
        System.out.println("Now what you want?");
        CommandInvoker invoker = new CommandInvoker();
        CommandCreator.initCreator();

        while(true){
            String userInput = getUserInput();
            UserCommand c = CommandCreator.getCommand(userInput);
            invoker.Invoke(c);
            if(CommandInvoker.checkOff()){
                break;
            }
        }

    }

    private static String getUserInput(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        return input;
    }
}


