import java.util.Scanner;

public class Duke {
    static Scanner scan = new Scanner(System.in);

    public static String echoInput(){
        String input = scan.nextLine();
        System.out.println("---------------------------------------");
        System.out.println(input);
        System.out.println("---------------------------------------");

        return input;
    }
    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("---------------------------------------");

        boolean isRunning = true;
        while(isRunning){
            String input = echoInput();
            if (input.equals("bye")){
                isRunning = false;
            }
        }

        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("---------------------------------------");
    }
}
