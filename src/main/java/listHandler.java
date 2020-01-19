public class listHandler extends UserCommand {

    private String toDo;
    listHandler(String s) {
        super(2);
        toDo = s;
    }

    @Override
    public void reply(){
        System.out.println("Sighhssss...I am your slave again?");
        System.out.println("added: " + toDo);
    }

    @Override
    public boolean action() {
        MyList.addItem(toDo);
        return true;
    }

}
