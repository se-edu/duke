import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        EventInvoker invoker = new EventInvoker();

        while(true){
            String userinput = getUserInput();
            UserCommand c = EventCreator.Create(userinput);
            if(c!=null && c.getID()==0){
                invoker.Invoke(c);
                break;
            }
            System.out.println(userinput);
        }

    }

    private static String getUserInput(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        return input;
    }
}


