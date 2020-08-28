import java.util.Scanner;

public class Main {
    public static void main(String[] args){
       System.out.println("____________________________________________________________");
       System.out.println("Hello! I'm Duke");
       System.out.println("What can I do for you?");
       Scanner in = new Scanner(System.in);

       String line;
       while(true){
           line = in.nextLine();
           if(line.equals("bye")){
               break;
           };
           System.out.println("____________________________________________________________");
           System.out.println(line);
           System.out.println("____________________________________________________________");
       }
       System.out.println("____________________________________________________________");
       System.out.println("Bye. Hope to see you again soon!");
       System.out.println("____________________________________________________________");
    }
}
