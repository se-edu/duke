import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {

        Duke_init.initBot();
        CommandInvoker invoker = new CommandInvoker();

        while(!CommandInvoker.checkOff()){
            String userInput = getUserInput();
            try {
                UserCommand c = CommandHub.FetchCommand(userInput);
                invoker.Invoke(c);
            }
            catch(DukeException e){
                System.out.println(e.getMessage());
            }

        }

    }

    private static String getUserInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print(">");
        String input = sc.nextLine();

        return input;
    }
}


