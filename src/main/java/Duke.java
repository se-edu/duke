import java.util.Scanner;

public class Duke {
    public static final String BYE_MESSAGE = ""
            + "____________________________________________________________\n"
            + "Bye. Hope to see you again soon!\n"
            + "____________________________________________________________\n";

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n"
                + "____________________________________________________________\n"
                + "Hello! I'm Duke\n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";
        System.out.println("Hello from\n" + logo);
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
        String[] list = new String[100];
        int index = 0;

        String input = in.nextLine();
        while((!input.equals("bye")) && (!input.equals("Bye"))){
            if(input.equals("list") || input.equals("List")){
                int count = 0;
                System.out.println("____________________________________________________________");
                while(list[count] != null){
                    System.out.println(""
                        + (count + 1) + "." + " "
                        + list[count]
                    );
                    count ++;
                }
                System.out.println("____________________________________________________________");
            }
            else{
                list[index] = input;
                System.out.println(""
                    + "____________________________________________________________\n"
                    + "added: " + input
                    + "\n____________________________________________________________\n"
                );
                index++;
            }
            input = in.nextLine();
        }
        System.out.println(BYE_MESSAGE);
    }
}

