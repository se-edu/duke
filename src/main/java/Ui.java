public class Ui {
    public void greet() {
        System.out.println("Hey, I'm Duke");
        System.out.println("What's up");
    }

    public String sayBye() {
        return "Bye.";
    }

    public String showListMsg() {
        return "Here are the tasks in your list: \n";
    }

    public String showDoneMsg() {
        return "Nice! I've marked this task as done: \n";
    }

    public String showAddTaskMsg() {
        return ("Got it. I've added this task: \n");
    }

    public String showRemoveTaskMsg() {
        return ("Noted! I've removed this task: ");
    }

    public String showCounterMsg(int counter) {
        return ("Now you have " + counter + " tasks in your list. \n");
    }

    public String showEmptyTaskMsg() {
        return "OOPS!!! The description cannot be empty :( \n";
    }

    public String showWrongFormat() {
        return "Did you mistype something? \n";
    }

    public String showNoMsgToDelete() {
        return "Looks like there's no message to be deleted. \n";
    }

    public String showFindTaskMsg() {
        return "Here are the matching tasks in your list: \n";
    }

    public String showErrorMsg() { return "Warning. Error. \n";}
}
