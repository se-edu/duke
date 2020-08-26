import java.util.Scanner;

public class Duke {
    static Scanner scan = new Scanner(System.in);
    static int wordListIndex = 0;
    static String wordList[] = new String[100];

    public static String addInput(String input){
        System.out.println("added: " + input);
        System.out.println("---------------------------------------");

        wordList[wordListIndex] = input;
        wordListIndex++;
        return input;

    }

    public static void listWordList(){
        int i = 1;
        for (String word : wordList){
            if (word == null) {
                if (i == 1){
                    System.out.println("---------------------------------------");
                }
                break;
            }
            else {
                System.out.println(String.valueOf(i) + ". " + word);
                i++;
            }
        }
        System.out.println("---------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("---------------------------------------");

        boolean isRunning = true;
        while(isRunning){
            String input = scan.nextLine();

            switch (input){
                case "bye" : {
                    isRunning = false;
                    break;
                }
                case "list" : {
                    listWordList();
                    break;
                }
                default:{
                    addInput(input);
                }
            }
        }

        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("---------------------------------------");
    }
}
