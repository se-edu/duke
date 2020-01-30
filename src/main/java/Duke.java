import java.util.Scanner;
import java.util.ArrayList;



public class Duke {

    //Class variables
    private ArrayList<Task> taskList;


    //Constructor
    public Duke() {
        this.taskList = new ArrayList<Task>();

    }

    //Logo generator
    public void printLogo(){
        for (int i = 0; i < 5; i++){
            String addOne = "*";
            String addTwo = "     *";
            String addThree = "*";
            String addFour = "     *";
            String addFive = "*";
            String addSix = "     *";
            for (int j = 0; j < i; j++){
                addOne += "*";
                addTwo += "*";
                addThree += "*";
                addFour += "*";
                addFive += "*";
                addSix += "*";
            }
            System.out.println(addOne + addTwo + addThree + addFour + addFive + addSix +
                                    addOne + addTwo + addThree + addFour + addFive + addSix);

        }
    }

    //Print all available tasks
    public void printTaskList(ArrayList<Task> taskList){
        int i = 1;
        for (Task task : taskList){
            String description = task.getDescription();
            String statusIcon = task.getStatusIcon();
            System.out.println(i + ". "  + "[" +  statusIcon + "]" + " " + description);
            i+= 1;
        }
    }


    //Mark as done
    public Boolean markDone(String line, ArrayList<Task> taskList) {
        String[] words = line.split(" ");
        int LENG_LIST = words.length;
        if (LENG_LIST == 1){
            if (words[0].toUpperCase().equals("DONE")) {
                System.out.println("Please specify (eg: done 2) or just add a new one");
                return true;
            }
        }
        Boolean isSet= false;
        if (words[0].toUpperCase().equals("DONE")) {
            int IDX_WORDS = Integer.parseInt(words[1]) - 1;
            if (words[1] == null){
                return isSet;
            } else if (IDX_WORDS < 0 || IDX_WORDS > taskList.size() -1) {
                System.out.println("Index is out of bounds, please try again!");
                return true;
            }
            taskList.get(Integer.parseInt(words[1]) - 1).markIt();
            String statusIcon = taskList.get(Integer.parseInt(words[1]) - 1).getStatusIcon();
            String description = taskList.get(Integer.parseInt(words[1]) - 1).getDescription();
            System.out.println((Integer.parseInt(words[1])) + ". "+ "[" + statusIcon + "]" + " " + description);
            System.out.println("Done! We have checked " + words[1] + "!");
            isSet = true;
            }
        return isSet;
    }


    //Add a task
    public void addTask(String line, ArrayList<Task> taskList) {

        String feedIn = line.toUpperCase();
        String ogString = line;
        while (!feedIn.equals("BYE")) {
            if (markDone(ogString, taskList)){
                System.out.println("___________________________________________________________________________\n");
            }
            else if (feedIn.equals("LIST")) {
                System.out.println("___________________________________________________________________________");
                this.printTaskList(taskList);
                System.out.println("___________________________________________________________________________");
            }

            else {
                System.out.println("___________________________________________________________________________");
                Task t = new Task(ogString);
                taskList.add(t);
                System.out.println("added: " + ogString + "\n");
                System.out.println("___________________________________________________________________________");
            }
            Scanner scanner = new Scanner(System.in);
            ogString = scanner.nextLine();
            feedIn= ogString.toUpperCase();


        }
        System.out.println("Bye. Hope to see you again soon!\n");
        System.out.println("___________________________________________________________________________");

    }


    //Get things started
    public void startThingsOff(){
        printLogo();
        Scanner scanner = new Scanner(System.in);
        String line;
        System.out.println("___________________________________________________________________________");
        System.out.println("Hello! I'm Hiroshi");
        System.out.println("Lets plan your day buddy! Things are looking good.\n");
        System.out.println("___________________________________________________________________________");
        line = scanner.nextLine();
        addTask(line, taskList);
        }


    public static void main(String[] args) {
        Duke hiroshiNagai = new Duke();
        hiroshiNagai.startThingsOff();

    }

}