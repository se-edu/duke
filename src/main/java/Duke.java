import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");
        List();

    }

    public static void List() {
        String list[] = new String[100];
        Scanner in = new Scanner(System.in);
        int number = 1;

        while (true){
        String line = in.nextLine();
        if (line.contains("bye") || line.equalsIgnoreCase("bye")) {
            Bye();
            break;
        }else if(line.equalsIgnoreCase("list")){
            for (int i=0;i<number-1;i++){
                System.out.println(i+1 + ". " + list[i]);
            }
        }else{
            list[number-1] = line;
            System.out.println("added " + line);
            number++;
        }
        }

    }
    public static void Bye(){
        System.out.println("Bye. Hope to see you again soon!");
    }

}
