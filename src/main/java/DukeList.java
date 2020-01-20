import java.util.LinkedList;
import java.util.List;

class DukeList {
    private List<Task> list;

     DukeList() {
        this.list = new LinkedList<>();
     }

     private DukeList(DukeList dl) {
         this.list = dl.list;
     }

    void addToList(String str) {
         this.list.add(new Task(str));
    }

    void printList() {
         for (int i = 1; i <= list.size(); i++) {
             System.out.println("   " + i + ". " + list.get(i - 1));
         }
    }

    DukeList setDone(int index) {
         DukeList dl = new DukeList(this);
         dl.list.set(index, new Task(this.list.get(index)));
         return dl;
    }

    String printTask(int index) {
         return this.list.get(index).toString();
    }
}
