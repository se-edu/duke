import java.util.HashMap;

public class List_Command extends UserCommand {
    List_Command() {
        super(3);
    }
    @Override
    public void reply(){
        MyList.printList();

    }
}
