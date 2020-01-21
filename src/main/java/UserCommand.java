public class UserCommand implements Commands{

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
    public boolean action() {
        return true;
    }


    @Override
    public int getID() {
        return ID;
    }
}
