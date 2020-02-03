public class LoadCommand extends AddCommand {

    private static boolean done = false;
    private static int count = 0;

    LoadCommand(String type, boolean setDone, String desc){
        super(type, desc);
        this.done = setDone;
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
