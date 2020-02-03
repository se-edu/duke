import java.util.HashMap;

public class ListCommand extends UserCommand {
    ListCommand() {
        super(3);
    }
    @Override
    public void reply(){
        MyList.printList();

    }
}
