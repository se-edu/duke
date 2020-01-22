public class Del_Command extends UserCommand {

    private static int id;
    Del_Command(int id){
        super(5);
        setDel(id);
    }

    @Override
    public void reply(){
        System.out.println("Erasing your tracks are you?");
    }


    public static void setDel(int ID){
        id = ID;
    }

    @Override
    public boolean action() throws DukeException {

        MyList.deleteItem(id);
        MyList.printCount();
        return true;
    }

}
