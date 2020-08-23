import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        dukeGreet();
        boolean dukeRunning = true;
        String userInput;
        while (dukeRunning){
            userInput = in.nextLine();
            if (userInput.equals("bye")){
                dukeRunning = false;
            }
            else {
                System.out.println(userInput);
            }
        }

        dukeGoodBye();
    }

    public static void printHorizontalLine(int length){
        for (int i = 0; i < length; i++){
            System.out.print("_");
        }
        System.out.print("\n");
    }

    public static void dukeGreet(){
        printHorizontalLine(50);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println();
    }

    public static void dukeGoodBye(){
        printHorizontalLine(50);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println();
        printHorizontalLine(50);
    }
}
