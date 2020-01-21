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

        bot.staticResponse(StaticReq.SAYHELLO);

        while ( !finished ){
            String input = sc.nextLine().toLowerCase();

            try {
                System.out.println("**********************************");

                if( input.equals("bye")  ){
                    finished = true;
                } else {
                    bot.res(input);
                    System.out.println("**********************************");
                }
            } catch( Exception e){
                System.out.println("I didn't get that. Would you mind repeating once more?");
            }

        }

        bot.staticResponse(StaticReq.SAYGOODBYE);


    }
}
