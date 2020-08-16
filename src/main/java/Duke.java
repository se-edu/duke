public class Duke {
    public static void main(String[] args) {
        /*
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("CAN YOU SEE THE CHANGE?");*/
        printHorizontalLine(50);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println();
        printHorizontalLine(50);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println();
        printHorizontalLine(50);
    }

    public static void printHorizontalLine(int length){
        for (int i = 0; i < length; i++){
            System.out.print("_");
        }
        System.out.print("\n");
    }
}
