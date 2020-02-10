package Frontend.Components.DialogBox;

import java.io.IOException;
import java.util.Collections;

import Frontend.Components.MainWindow;
import Frontend.Objects.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

/**
 * An example of a custom control using FXML.
 * This control represents a dialog box consisting of an ImageView to represent the speaker's face and a label
 * containing text from the speaker.
 *
 *    Title: JavaFX Tutorial
 *    Author: Jeffry Lum, Damith C. Rajapakse
 *    Availability: https://github.com/se-edu/duke/blob/master/tutorials
 */
public abstract class DialogBox extends HBox {
    @FXML
    protected Label dialog;
    @FXML
    protected ImageView displayPicture;

    public DialogBox( User user) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader( MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText( user.getText() );
        dialog.prefHeight( Region.USE_COMPUTED_SIZE );
//        displayPicture.setImage( user.getImage() );

    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    protected void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);
    }

}