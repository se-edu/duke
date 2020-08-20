public class Duke {
    public static void main(String[] args) {
        String initial = "____________________________________________________________\n"
                + "Hello! I'm Duke\n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";
        System.out.println(initial);
        for(String word : args) {
            if(word.equals("bye")) {
                System.out.println(
                    "____________________________________________________________\n"
                    + "Bye. Hope to see you again soon!\n"
                    + "____________________________________________________________\n"
                );
                break;
            } else {
                System.out.println(
                    "____________________________________________________________\n"
                    + word + " \n"
                    + "____________________________________________________________\n"
                );
            }
        }
    }
}
