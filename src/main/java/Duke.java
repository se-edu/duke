import common.Storage;
import command.Command;
import exception.DukeException;
import task.TaskList;
import parser.*;

import ui.TextUi;

/**
 * main class of Duke program
 * controlling the main logic
 */
public class Duke {

    private TextUi textUi;
    private Storage dukeStorage;
    private TaskList tasks;

    public Duke(String filePath) {
        textUi = new TextUi();
        dukeStorage = new Storage(filePath);
        try {
            tasks = new TaskList(dukeStorage.readFromFile());
        } catch (exception.DukeException e) {
            textUi.showError(e.getMessage());
            tasks = new TaskList();
        }
    }

    public void run(){
        textUi.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                //System.out.println("Prepare to take in commands.");
                String fullCommand = textUi.readCommand();
                //System.out.println("fullCommand : " + fullCommand);
                //textUi.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, textUi, dukeStorage);
                isExit = c.isExit();
            } catch (DukeException e) {
                textUi.showError(e.getMessage());
            }
        }
        exit();
    }

    public static void main(String[] args) {
        new Duke("tasks.txt").run();
    }

    public void exit() {
        textUi.showGoodBye();
        System.exit(0);
    }

}
