package ui;

import exception.DukeException;

import common.Message;
import task.Task;
import task.TaskList;

import java.io.PrintStream;
import java.util.Scanner;

public class TextUi {

    private Scanner sc;
    private PrintStream out;

    public TextUi(){
        this.sc = new Scanner(System.in);
        this.out = new PrintStream(System.out);
    }

    /** Shows (lines of) message(s) to the user */
    public void showToUser(String... message) {
        for (String m : message) {
            out.println(m);
        }
    }

    /** Shows welcome words to the user */
    public void showWelcome(){
        showToUser(
                "Hello from",
                Message.MESSAGE_LOGO,
                Message.MESSAGE_LINE,
                "     Hello! I'm Duke",
                "     What can I do for you?",
                Message.MESSAGE_LINE
        );
    }

    /** Shows goodBye words to the user */
    public void showGoodBye(){
        showToUser(
                Message.MESSAGE_LINE,
                "     Bye. Hope to see you again soon!",
                Message.MESSAGE_LINE
        );
    }

    /** Shows the dividing line */
    public void showLine(){
        showToUser(Message.MESSAGE_LINE);
    }

    public void showAddingTask(Task givenTask, TaskList tasks){
        showToUser(
                Message.MESSAGE_LINE,
                Message.MESSAGE_GOTIT,
                "     " + givenTask.toString(),
                "     Now you have " + tasks.getList().size()
                        + " tasks in the list.",
                Message.MESSAGE_LINE
        );
    }

    public void showDeletingTask(int index, TaskList tasks){
        showToUser(
                Message.MESSAGE_LINE,
                Message.MESSAGE_DELETEIT,
                "     " + tasks.getList().get(index).toString(),
                "     Now you have " + (tasks.getList().size() - 1)
                        + " tasks in the list.",
                Message.MESSAGE_LINE
        );
    }

    public void showDoneTask(int index, TaskList tasks){
        showToUser(
                Message.MESSAGE_LINE,
                Message.MESSAGE_MARKASDONE,
                "     " + tasks.getList().get(index).toString(),
                Message.MESSAGE_LINE
        );
    }

    public void showError(String errorMessage){
        showToUser(
                new DukeException(errorMessage).toString()
        );

    }

    /** Takes in the user input line */
    public String readCommand(){
        String input = sc.nextLine().trim();
        while(input.equals("")){
            input = sc.nextLine();
        }
        return input;
    }

    public void displayList(TaskList tasks){
        showToUser(
                Message.MESSAGE_LINE,
                Message.MESSAGE_SHOWLIST
        );
        if(tasks.getList().isEmpty()){
            showToUser(
                    Message.MESSAGE_EMPTYLIST,
                    Message.MESSAGE_LINE
            );
        } else {
            for (int i = 0; i < tasks.getList().size(); i++) {
                showToUser("     " + (i + 1) + ". " + tasks.getList().get(i).toString());
            }
            showLine();
        }
    }

}
