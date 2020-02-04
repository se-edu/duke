import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * An example of a custom control using FXML.
 * This control represents a dialog box consisting of an ImageView to represent the speaker's face and a label
 * containing text from the speaker.
 */
public class DialogBox extends HBox {
    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    public DialogBox( String text, ImageView img) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader( MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialog.setText(text);
        displayPicture.setImage( img.getImage() );
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);
    }

    public static DialogBox getUserDialog( String text, Image img) {

        ImageView imgView = new ImageView();
        imgView.setImage( img );

        DialogBox UserDialogBox = new DialogBox(text, imgView );

        UserDialogBox.getStyleClass().add("dialog-container-user");
        UserDialogBox.dialog.getStyleClass().add("dialog-label-user");

        return UserDialogBox;

    }

    public static DialogBox getDukeDialog( String text, Image img) {

        ImageView imgView = new ImageView();
        imgView.setImage( img );

        DialogBox DukeDialogBox = new DialogBox(text, imgView);

        DukeDialogBox.getStyleClass().add("dialog-container-duke");
        DukeDialogBox.dialog.getStyleClass().add("dialog-label-duke");
        DukeDialogBox.dialog.setTextFill( Color.web("#fff") );

        DukeDialogBox.flip();
        return DukeDialogBox;
    }
}