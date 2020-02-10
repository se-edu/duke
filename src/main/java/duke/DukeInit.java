package duke;

import commands.CommandHub;
import database.Storage;

/**
 * Initialises the bot
 */
public class DukeInit {
    private static String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    /**
     * Initalises bot.
     */
    public static void initBot(){

        System.out.println("Hello from\n" + logo);
        System.out.println("I am a very angry bot and I hate you");
        CommandHub.initCreator(); //init commands
        Storage.memory_Init(); //init memory
        System.out.println("Now what you want?");
    }

    public static String getInitLine(){
        return "Hello.. I am \n" + logo + "\nI am a very angry bot and I hate you";
    }

}
