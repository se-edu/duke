public class EventInvoker {

    public static boolean endProgram = false;
    EventInvoker(){};
    EventInvoker(UserCommand c){
        Invoke(c);
    }


    public void Invoke(UserCommand c){
        int ID = c.getID();
        c.reply();
        if(ID == 0 ){
            endProgram = true;
        }
    }


}
