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
            throw new DukeException("Lol.. how about you delete yourself first!");
        }
        System.out.println("Deleted: " + DaList.get(ID));
        DaList.remove(ID);
    }


    public static void printList(){ //run n times
        if(DaList.size()==0){
            System.out.println("LOL.. You have nothing inside your list!");
        }
        /*for(int i = 1 ; i < count ; i ++){
            System.out.println(i+ ". "+ Dalist[i]);
        }*/
        int count = 1;
        for(Task t : DaList){
            System.out.println(count+ ". "+ t);
            count++;
        }
    }

    public static void printCount(){
        //System.out.println("Now you have "+ (count-1) + " things in your bloody list..");
        System.out.println("Now you have "+ DaList.size() + " things in your bloody list..");
    }

    public static void markDone(int ID) throws DukeException{
        ID = ID-1;
        if(ID>=DaList.size()|| ID<0){
            throw new DukeException("You want to finish something imaginary??? Please.. are you stupid?");
        }
        DaList.get(ID).markDone();
        //Dalist[ID].markDone();
        System.out.println(DaList.get(ID));
    }

    public static ArrayList getList(){
        return DaList;
    }
}
