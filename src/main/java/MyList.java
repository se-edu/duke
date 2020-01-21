public class MyList {
    private static Task[] Dalist= new Task[100];
    private static int count = 1;


    public static void addItem(Task t){
        Dalist[count] = t;
        System.out.println("Now you have "+ count + " things in your bloody list..");
        count++;

    }

    public static void deleteItem(int ID){
        count--;
        push(ID);
    }

    private static void push(int start){
        int pushed = start + 1;
        for(int i = start ; i <count+1 ; i++){
            Dalist[start] = Dalist[pushed];
        }
    }

    public static void printList(){ //run n times
        if(count==1){
            System.out.println("LOL.. You have nothing inside your list!");
        }
        for(int i = 1 ; i < count ; i ++){
            System.out.println(i+ ". "+ Dalist[i]);
        }
    }

    public static void markDone(int ID) throws DukeException{
        if(ID>=count){
            throw new DukeException("You want to finish something imaginary??? Please.. are you stupid?");
        }
        Dalist[ID].markDone();
        System.out.println(Dalist[ID]);
    }



}
