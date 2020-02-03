public class Done_Command extends UserCommand {
    static int id=0;
    Done_Command(int id) {
        super(4);
        setDone(id);
    }


    @Override
    public void reply(){
        System.out.println(UI.getReply("markedDone"));
        System.out.println("Marking item " + id +" as done");
    }

    public static void setDone(int ID){
        id = ID;
    }

    @Override
    public boolean action() throws DukeException {
        MyList.markDone(id);
        return true;
    }
}
