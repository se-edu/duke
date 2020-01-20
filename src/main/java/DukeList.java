import java.util.LinkedList;
import java.util.List;

class DukeList {
    List<String> list;

     DukeList() {
        this.list = new LinkedList<>();
     }

    void addToList(String str) {
         this.list.add(str);
    }

    void printList() {
         for (int i = 1; i <= list.size(); i++) {
             System.out.println("   " + i + ". " + list.get(i - 1));
         }
    }
}
