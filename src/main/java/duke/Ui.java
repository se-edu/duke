package duke;

public class Ui {
    public void greet() {
        System.out.println("Hey, I'm Duke");
        System.out.println("What's up");
    }

    public String sayBye() {
        return "Bye.";
    }

    public String showListMsg() {
        return "Here are the tasks in your list: ";
    }

    public String showDoneMsg() {
        return "Nice! I've marked this task as done: ";
    }

    public String showAddTaskMsg() {
        return ("Got it. I've added this task: ");
    }

    public String showRemoveTaskMsg() {
        return ("Noted! I've removed this task: ");
    }

    public String showCounterMsg(int counter) {
        return ("Now you have " + counter + " tasks in your list.");
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

    public String showFindTaskMsg() {
        return "Here are the matching tasks in your list: ";
    }
}
