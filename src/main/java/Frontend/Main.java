package Frontend;

import Backend.Exceptions.DukeException;
import Backend.Storage;
import Backend.Switcher;
import Backend.TaskList;
import Frontend.Components.DialogBox.DukeDialogBox;
import Frontend.Components.DialogBox.UserDialogBox;
import Frontend.Objects.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This class handles all frontend rendering of components.
 * Only functions that deal with the user interface should be included.
 *
 *    With references to:
 *    Title: JavaFX Tutorial
 *    Author: Jeffry Lum, Damith C. Rajapakse
 *    Availability: https://github.com/se-edu/duke/blob/master/tutorials
 */
public class Main extends Application {

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private AnchorPane mainLayout;

    private User user = new User("/images/DaUser.png");
    private User duke = new User("/images/DaDuke.png");

    private TaskList taskList;
    private Switcher switcher;

    @Override
    public void start( Stage stage ) {
        initialiseBackendComponents();
        initialiseComponents();
        resizeComponents(stage);
        setHandlers();
    }

    /**
     * Displays the text value of multiple users and handles empty texts.
     * Clears the text field and the text value of the user once display is done.
     * @param duke The Duke
     * @param user The User
     */
    private void displayUserInput(User duke, User user){

        if( user.getText().length() > 0 ){
            dialogContainer.getChildren().add(
                    new UserDialogBox( user )
            );

            user.clearText();
        }

        if( duke.getText().length() > 0 ){
            dialogContainer.getChildren().add(
                    new DukeDialogBox( duke )
            );

            duke.clearText();
        }

        userInput.clear();

    }

    /**
     * Retrieves user input and displays response.
     * Also handles a DukeException but does not handle any logic.
     */
    private void handleUserInput() {

        try {

            user.addText( userInput.getText() );
            duke.addText( switcher.res(user.getText()) );

            displayUserInput( duke, user );

        } catch ( DukeException e ){

            duke.addText(e.getErrorMsg());
            displayUserInput( duke, user );

        }

    }

    /**
     * Handles the initialisation of all backend components
     */
    private void initialiseBackendComponents(){
        taskList = new TaskList();

        try {
            taskList.loadTasks( Storage.loadFromFile() );
        } catch ( DukeException ignored){

        } finally {

            switcher = new Switcher( taskList );

        }

    }

    /**
     * Handles the initialisation of all rendered components
     */
    private void initialiseComponents(){
        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);

        userInput = new TextField();
        sendButton = new Button("Send");

        mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        scene = new Scene(mainLayout);

        /**
         * adding css files
         */
        scene.getStylesheets().addAll(
                "/view/MainWindow.css",
                "/view/DialogBox.css"
        );
    }

    /**
     * Sets widths and heights for various components.
     * Sets positioning of child elements
     * @param stage top level JavaFX container
     */
    private void resizeComponents(Stage stage){

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Frontend.Duke");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);

        mainLayout.setPrefSize(400.0, 600.0);

        scrollPane.setPrefSize(385, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        // You will need to import `javafx.scene.layout.Region` for this.
        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);

        userInput.setPrefWidth(325.0);

        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput , 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);
    }

    /**
     * Binds functions to various components
     */
    private void setHandlers(){
        //Scroll down to the end every time dialogContainer's height changes.
        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));

        //handles mouse click
        sendButton.setOnMouseClicked((event) -> {
            handleUserInput();
        });

        //handles key press
        userInput.setOnAction((event) -> {
            handleUserInput();
        });
    }

}
