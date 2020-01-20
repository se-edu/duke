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

    DukeList addToList(Task task) {
         DukeList dl = new DukeList(this);
         dl.list.add(task);
         return dl;
    }

    void printList() {
         for (int i = 1; i <= list.size(); i++) {
             System.out.println("   " + i + ". " + list.get(i - 1));
         }
    }

    DukeList setDone(int index) {
         DukeList dl = new DukeList(this);
         dl.list.set(index, this.list.get(index).completeTask());
         return dl;
    }

    String printTask(int index) {
         return this.list.get(index).toString();
    }

    int listSize() {
         return this.list.size();
    }
}
