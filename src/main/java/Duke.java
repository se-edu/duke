import java.util.Scanner;

public class Duke {
    public static final String BYE_MESSAGE = ""
            + "____________________________________________________________\n"
            + "Bye. Hope to see you again soon!\n"
            + "____________________________________________________________\n";
    public static final String WELCOME_MESSAGE = ""
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n"
            + "____________________________________________________________\n"
            + "Hello! I'm Duke\n"
            + "What can I do for you?\n"
            + "____________________________________________________________\n";

    public static void main(String[] args) {
        System.out.println("Hello from\n" + WELCOME_MESSAGE);
        addList();
    }

    public static void getInput() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while((!input.equals("bye")) && (!input.equals("Bye"))){
            System.out.println(""
                + "____________________________________________________________\n"
                + input
                + "\n"
                + "____________________________________________________________\n"
            );
            input = in.nextLine();
        }
        System.out.println(BYE_MESSAGE);
    }

    public static void addList(){
        Scanner in = new Scanner(System.in);
        Task[] list = new Task[100];
        int index = 0;

        String input = in.nextLine();
        while((!input.equals("bye")) && (!input.equals("Bye"))){
            if(input.equals("list") || input.equals("List")){
                int count = 0;
                System.out.println("____________________________________________________________");
                while(list[count] != null){
                    System.out.println(""
                        + (count + 1) + "." + "[" + list[count].getStatusIcon() + "]" + " "
                        + list[count].description
                    );
                    count ++;
                }
                System.out.println("____________________________________________________________");
            }
            else if(input.contains("done") || input.contains("Done")){
                String checkedStrIndex = input.replaceAll("[^0-9]", "");
                int checkedIntIndex = Integer.parseInt(checkedStrIndex);
                if(checkedIntIndex <= index + 1 && checkedIntIndex > 0){
                    list[checkedIntIndex - 1].checkDone();
                }
                System.out.println(""
                    + "____________________________________________________________\n"
                    + "Nice! I've marked this task as done:\n"
                    + "  " + "[" + list[checkedIntIndex - 1].getStatusIcon() + "]"
                    + list[checkedIntIndex - 1].description
                    + "\n____________________________________________________________"

                );
            }
            else{
                list[index] = new Task(input);
                System.out.println(""
                    + "____________________________________________________________\n"
                    + "added: " + list[index].description
                    + "\n____________________________________________________________\n"
                );
                index++;
            }
            input = in.nextLine();
        }
        System.out.println(BYE_MESSAGE);
    }
}

