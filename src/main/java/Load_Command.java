public class Load_Command extends Add_Command {

    private static boolean done = false;
    private static int count = 0;

    Load_Command(String type, boolean setDone,String desc){
        super(type, desc);
      //  System.out.println("Discorvers " + type + " in loadcommand");
        this.done = setDone;
    }

    @Override
    public void reply(){
        //do nothing
    }

    @Override
    public boolean action() throws DukeException {
        super.action();
        count++;
        if(done){
            MyList.markDone(count);
        }
        return true;
    }
}
