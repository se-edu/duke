import java.util.*;

public class Duke {

    public static final String LINE = "____________________________________________________________";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        greet();

        ArrayList<String> list = new ArrayList<>();

        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                exit();
            } else if (input.equalsIgnoreCase("list")) {
                displayList(list);
            } else {
                addItem(list, input);
                echo(input);
            }
        }
    }

    public static void greet(){
        String firstGreet = LINE
                + "\n Hello! I'm Duke \n"
                + " What can I do for you? \n"
                + LINE;
        System.out.println(firstGreet);
    }

    public static void exit(){
        String directAnswer = LINE + "\n" + " Bye. Hope to see you again soon!" + "\n" + LINE;
        System.out.println(directAnswer + "\n");
        System.exit(0);
    }

    public static void echo(String input){
        String directAnswer = LINE + "\n" + " added: " + input + "\n" + LINE;
        System.out.println(directAnswer + "\n");
    }

    public static void addItem(ArrayList<String> list, String newItem){
        list.add(newItem);
    }

    public static void displayList(ArrayList<String> list){
        int marker = 1;
        if(list.isEmpty()){
            System.out.println(LINE + "\n\n" + LINE + "\n");
        } else {
            System.out.println(LINE);
            for(int i = 0; i < list.size(); i++){
                System.out.println(" " + (i + 1) + ". " + list.get(i));
            }
            System.out.println(LINE + "\n");
        }
    }
}
