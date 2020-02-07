package Frontend.Components.DialogBox;

import Frontend.Objects.User;

public class UserDialogBox extends DialogBox {

    public UserDialogBox( User user ){
        super( user );

        this.getStyleClass().add("user-container-duke");
        dialog.getStyleClass().add("user-label-duke");

    }

}
