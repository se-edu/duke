import java.util.ArrayList;

public class MyList {
    private static ArrayList<Task> DaList = new ArrayList<>();


    public static void addItem(Task t){
        System.out.println("added: " + t);
        DaList.add(t);
    }

    public static void deleteItem(int ID)throws DukeException{
        ID = ID-1;
        if(ID>=DaList.size()|| ID<0){
            throw new DukeException(UI.getReply("deleteEmpty"));
        }
        System.out.println("Deleted: " + DaList.get(ID));
        DaList.remove(ID);
    }


    public static void printList(){
        if(DaList.size()==0){
            System.out.println(UI.getReply("emptyList"));
        }
        int count = 1;
        for(Task t : DaList){
            System.out.println(count+ ". "+ t);
            count++;
        }
    }

    public static void printCount(){
        System.out.println("Now you have "+ DaList.size() + " things in your bloody list..");
    }

    public static void markDone(int ID) throws DukeException{
        ID = ID-1;
        if(ID>=DaList.size()|| ID<0){
            throw new DukeException(UI.getReply("imaginary"));
        }
        DaList.get(ID).markDone();
        System.out.println(DaList.get(ID));
    }

    public static ArrayList getList(){
        return DaList;
    }
}
