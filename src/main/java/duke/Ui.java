package duke;

public class Ui {
    public void greet() {
        System.out.println("Hey, I'm Duke");
        System.out.println("What's up");
    }

    public void showLoadingError() {
        System.out.println("It seems there are some problems with loading your file.");
    }

    public void sayBye() {
        System.out.println("Bye.");
    }

    public void showListMsg() {
        System.out.println("Here are the tasks in your list: ");
    }

    public void showDoneMsg() {
        System.out.println("Nice! I've marked this task as done: ");
    }

    public void showAddTaskMsg() {
        System.out.println("Got it. I've added this task: ");
    }

    public void showRemoveTaskMsg() {
        System.out.println("Noted! I've removed this task: ");
    }

    public void showCounterMsg(int counter) {
        System.out.println("Now you have " + counter + " tasks in your list.");
    }

    public String showEmptyTaskMsg() {
        return "OOPS!!! The description cannot be empty :(";
    }

    public String showWrongFormat() {
        return "Did you mistype something?";
    }

    public String showNoMsgToDelete() {
        return "Looks like there's no message to be deleted.";
    }
}
