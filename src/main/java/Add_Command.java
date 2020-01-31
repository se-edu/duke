public class Add_Command extends UserCommand {

    private static String desc;
    private static String type;
    private Task t;
    Add_Command() {
        super(2);
    }

    Add_Command(String type, String desc){
        super(2);
        this.desc = desc;
        this.type = type;
    }

    @Override
    public void reply(){
        System.out.println("Sighhssss...I am your slave again?");
    }

    @Override
    public boolean action() throws DukeException {
        if(type.equals("todo")){
            t = new ToDos(desc);
        }
        else if(type.equals("event")){
            t= new Event(desc);
        }
        else{
            t = new Deadlines(desc);
        }

        MyList.addItem(t);
        MyList.printCount();
        return true;
    }

}
