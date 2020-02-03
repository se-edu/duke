package duke;

import duke.command.Command;
import duke.command.CommandResult;
import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.nio.file.Path;

public class Duke extends Application {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Empty constructor so that Launcher works.
     */
    public Duke() {
        String home = System.getProperty("user.home");
        Path filePath = java.nio.file.Paths.get(home, "Desktop", "GitHub", "duke","data","data.txt");
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }

    }

    /**
     * Initiate the Duke bot.
     * create UI, duke.storage.Storage, duke.task.TaskList.
     * @param filePath filePath stores the txt file used to load data.
     */
    public Duke(Path filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }


    /**
     * Chat bot function, run infinitely until user types "bye".
     */
    public void runChatBot() {
        this.ui.welcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parseMessage(fullCommand);
                CommandResult commandResult = c.execute(tasks, ui, storage);
                isExit = c.getIsExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    /**
     * Starts GUI.
     * @param stage stage of the GUI.
     */
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label

        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.
    }

    /**
     * Prints a logo of the name Duke.
     * @param args Set up main function
     */
    public static void main(String[] args) {
        String home = System.getProperty("user.home");
        Path path = java.nio.file.Paths.get(home, "Desktop", "GitHub", "duke","data","data.txt");
        new Duke(path).runChatBot();
    }

}
