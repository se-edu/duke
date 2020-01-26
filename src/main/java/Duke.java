import java.util.Scanner;
import java.util.Arrays;

public class Duke {

    public static void printItems(String[] items){
        System.out.println(Arrays.toString(items));

    }


    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("___________________________________________________________________________");

        String[] listTasks = new String[100];
        int counter = 0;
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");


        Scanner scanner = new Scanner(System.in);
        String line;




            System.out.println("___________________________________________________________________________");
            line = scanner.nextLine();
            listTasks[counter] = line;
            System.out.println("added: " + line + "\n");
            counter +=1;
            System.out.println("___________________________________________________________________________");
        while (!line.toUpperCase().equals("BYE")) {
            line = scanner.nextLine();

            if (line.toUpperCase().equals("LIST")){
                for (int i = 0; i < counter; i++){
                    System.out.println((i+1) + ". " + listTasks[i]);
                }

            }
            else{
                listTasks[counter] = line;
                System.out.println("added: " + line + "\n");
                counter +=1;

            }

            System.out.println("___________________________________________________________________________");

        }




        System.out.println("Bye. Hope to see you again soon!\n");

        System.out.println("___________________________________________________________________________");


    }
}