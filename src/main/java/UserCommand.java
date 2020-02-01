public class UserCommand implements Command {

   // private  String myWords;
    private int ID = 0;


    UserCommand(){
    };

    UserCommand(int id){
        ID = id;
    };


    @Override
    public void reply() {
        System.out.println("This is some crazy event");
    }

    @Override
    public boolean action() throws DukeException {
        return true;
    }


    @Override
    public int getID() {
        return ID;
    }
}
