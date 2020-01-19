public class Bye extends UserCommand{

    private int ID = 0;

    @Override
    public void reply() {
        System.out.println("Bye. Have a nice day lol you shit...");
    }

    @Override
    public int action() {
        //does nothign
        return 0;
    }

    @Override
    public int getID() {
        return ID;
    }


    @Override
    public java.lang.String toString() {
        return "Bye. Have a nice day lol you shit...";
    }
}
