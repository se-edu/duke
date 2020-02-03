public class ByeCommand extends UserCommand{

    ByeCommand() {
     super(1);
    }


    @Override
    public void reply() {
        System.out.println(UI.getReply("bye"));
    }

    @Override
    public boolean action() throws DukeException {
        Storage.saveMemory();
        CommandInvoker.stop();
        return true;
    }

}
