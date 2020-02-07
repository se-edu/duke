package Frontend.Components.DialogBox;
import Frontend.Objects.User;

import javafx.scene.paint.Color;

public class DukeDialogBox extends DialogBox {

    public DukeDialogBox( User user ){
        super(user);

        this.getStyleClass().add("dialog-container-duke");
        dialog.getStyleClass().add("dialog-label-duke");
        dialog.setTextFill( Color.web( "#fff" ));

        this.flip();
    }

}
