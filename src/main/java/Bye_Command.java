public class Bye_Command extends UserCommand{

    Bye_Command() {
     super(1);
    }


    @Override
    public void reply() {
        System.out.println("Bye. Have a nice day lol you shit...");
    }

    @Override
    public boolean action() throws DukeException {
        Bot_Memory.saveMemory();
        CommandInvoker.stop();
        return true;
    }

}
