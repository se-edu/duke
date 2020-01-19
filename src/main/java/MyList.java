public class MyList extends UserCommand {
    private static Task[] Dalist= new Task[100];
    private static int count = 1;

    MyList(){
        super(3);
    }
    @Override
    public void reply(){
        for(int i = 1 ; i < count ; i ++){
            System.out.println(i+ ". "+ Dalist[i]);
        }
    }

    public static void addItem(String item){
        Dalist[count] = new Task(item);
        count++;
    }

    public static void deleteItem(int ID){}

}
