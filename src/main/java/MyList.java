public class MyList {
    private static Task[] Dalist= new Task[100];
    private static int count = 1;

    public static void addItem(String item){
        Dalist[count] = new Task(item);
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
        for(int i = 1 ; i < count ; i ++){
            System.out.println(i+ ". "+ Dalist[i]);
        }
    }

    public static void markDone(int ID){
        Dalist[ID].markDone();
        System.out.println(Dalist[ID]);
    }



}
