public class Bye extends UserCommand{

    Bye() {
     super(1);
    }


    @Override
    public void reply() {
        System.out.println("Bye. Have a nice day lol you shit...");
    }

    @Override
    public boolean action() {
        CommandInvoker.stop();
        return true;
    }

}
