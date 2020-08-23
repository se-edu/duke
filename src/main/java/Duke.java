import java.util.Scanner;

public class Duke {
    static String[] storedUserInputs = new String[100];
    static int numberStoredInputs = 0;

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
            else if (userInput.equals("list")){
                dukeRepeatInputs();
            }
            else {
                dukeEcho(userInput);
                storedUserInputs[numberStoredInputs] = userInput;
                numberStoredInputs++;
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

    public static void dukeEcho(String userInput){
        printHorizontalLine(50);
        System.out.println("added: " + userInput);
        printHorizontalLine(50);
    }

    public static void dukeRepeatInputs(){
        printHorizontalLine(50);
        for (int i = 0; i < numberStoredInputs; i++){
            System.out.println((i+1) + ". " + storedUserInputs[i]);
        }
        printHorizontalLine(50);
    }
}
