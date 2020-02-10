package duke;

import commands.CommandHub;
import commands.CommandInvoker;
import commands.UserCommand;
import exceptions.DukeException;

import java.util.Scanner;

public class Duke {
    CommandInvoker invoker  = new CommandInvoker();

    public Duke() {
        DukeInit.initBot();
    }

    public static void main(String[] args) {
        new Duke().run();
    }

    public void run(){

        while(!CommandInvoker.checkOff()){
            String userInput = getUserInput();
            try {
                UserCommand c = CommandHub.fetchCommand(userInput);
                invoker.invoke(c);
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

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    public String getResponse(String input) {
        String response="";
        try {
            UserCommand c = CommandHub.fetchCommand(input);
            response = invoker.invoke(c);
            if(CommandInvoker.checkOff()){
                System.exit(0);
            }
        }
        catch(DukeException e){
            response = e.getMessage();
        }


        return response;
    }
}


