import java.util.Scanner;

/**
 * Duke Program for CS2103T 2020.
 */
public class Duke {
    /**
     * The main method.
     * @param args args
     */
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        /**
         * initialize variables
         */
        Scanner sc = new Scanner(System.in);
        Bot bot = new Bot();
        boolean finished = false;

        bot.staticResponse(StaticResponse.SAYHELLO);

        while ( !finished ){
            String input = sc.nextLine();

            System.out.println("**********************************");

            if( input.equals("bye")  ){
                finished = true;
            } else {
                bot.echo(input);
                System.out.println("**********************************");
            }



        }

        bot.staticResponse(StaticResponse.SAYGOODBYE);


    }
}
