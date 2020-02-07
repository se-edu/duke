package Frontend.Components;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
/**
 * Controller for Frontend.Components.MainWindow. Provides the layout for the other controls.
 *
 *    Title: JavaFX Tutorial
 *    Author: Jeffry Lum, Damith C. Rajapakse
 *    Availability: https://github.com/se-edu/duke/blob/master/tutorials
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

}