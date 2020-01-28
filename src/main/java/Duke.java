import common.Storage;
import command.Command;
import exception.DukeException;
import task.TaskList;
import parser.*;

import ui.TextUi;

/**
 * main class of Duke program
 * controlling the main logic
 */
public class Duke {

    private TextUi textUi;
    private Storage dukeStorage;
    private TaskList tasks;

    public Duke(String filePath) {
        textUi = new TextUi();
        dukeStorage = new Storage(filePath);
        try {
            tasks = new TaskList(dukeStorage.readFromFile());
        } catch (exception.DukeException e) {
            textUi.showError(e.getMessage());
            tasks = new TaskList();
        }
    }

    public void run(){
        textUi.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                //System.out.println("Prepare to take in commands.");
                String fullCommand = textUi.readCommand();
                //System.out.println("fullCommand : " + fullCommand);
                //textUi.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, textUi, dukeStorage);
                isExit = c.isExit();
            } catch (DukeException e) {
                textUi.showError(e.getMessage());
            }
        }
        exit();
    }

    public static void main(String[] args) {
        new Duke("tasks.txt").run();
    }


    /*public static void main(String[] args) throws DukeException {


        while(scanner.hasNextLine()) {

            String input = scanner.nextLine().trim();
            if (input.equals("bye")) {
                exit();
            } else { //not bye
                String[] words = input.split(" ");
                keyword = words[0];
                if (keyword.equals("done")) { // case done
                    try {
                        if (words.length != 2) {
                            throw new DukeException("The done message is not valid.");
                        }
                    } catch (DukeException exp) {
                        System.out.println(exp.toString() + "\n");
                        continue;
                    }
                    int thisIndex = -1;
                    try {
                        thisIndex = Integer.parseInt(input.substring(5)) - 1;
                    } catch (Exception exp) {
                        System.out.println(new DukeException("Index is not detected.").toString() + "\n");
                        continue;
                    }

                    thisIndex = Integer.parseInt(input.substring(5)) - 1;
                    if (thisIndex >= list.size() || thisIndex < 0) {
                        continue;
                    }
                    System.out.println(Message.MESSAGE_LINE);
                    System.out.println(Message.MESSAGE_MARKASDONE);
                    list.get(thisIndex).markAsDone();
                    dukeStorage.writeToFile(list);
                    System.out.println("       " + list.get(thisIndex).toString());
                    System.out.println(Message.MESSAGE_LINE + "\n");
                } else if (keyword.equals("delete")) { // case delete
                    try {
                        if (words.length != 2) {
                            throw new DukeException("The delete message is not valid.");
                        }
                    } catch (DukeException exp) {
                        System.out.println(exp.toString() + "\n");
                        continue;
                    }
                    int thatIndex = -1;
                    try {
                        thatIndex = Integer.parseInt(input.substring(7)) - 1;
                    } catch (Exception exp) {
                        System.out.println(new DukeException("Index is not detected.").toString() + "\n");
                        continue;
                    }

                    thatIndex = Integer.parseInt(input.substring(7)) - 1;
                    if (thatIndex >= list.size() || thatIndex < 0) {
                        continue;
                    }
                    System.out.println(Message.MESSAGE_LINE);
                    System.out.println(Message.MESSAGE_DELETEIT);
                    System.out.println("       " + list.get(thatIndex).toString());
                    list.remove(thatIndex);
                    dukeStorage.writeToFile(list);
                    System.out.println("     Now you have " + list.size() + " tasks in the list. ");
                    System.out.println(Message.MESSAGE_LINE + "\n");

                } else if (input.equalsIgnoreCase("list")) { //case list
                    displayList(list);
                } else { // case tasks
                    Task thisTask;
                    String[] stamps = input.split("/");

                    duke.TaskEnum taskEnum = duke.TaskEnum.OTHERS;
                    if (keyword.equalsIgnoreCase("todo")) {
                        taskEnum = duke.TaskEnum.TODO;
                    } else if (keyword.equalsIgnoreCase("event")) {
                        taskEnum = duke.TaskEnum.EVENT;
                    } else if (keyword.equalsIgnoreCase("deadline")) {
                        taskEnum = duke.TaskEnum.DEADLINE;
                    }

                    switch (taskEnum) {
                        case TODO:
                            try {
                                if (words.length < 2) {
                                    throw new DukeException("The description of a todo cannot be empty.");
                                }
                            } catch (DukeException exp) {
                                System.out.println(exp.toString() + "\n");
                                continue;
                            }
                            thisTask = new Todo(input.substring(5));
                            break;

                        case EVENT:
                            try {
                                if (words.length < 4 || stamps.length < 2) {
                                    throw new DukeException("The content of an event must be complete.");
                                }
                            } catch (DukeException exp) {
                                System.out.println(exp.toString() + "\n");
                                continue;
                            }
                            String[] eveWords = input.split("/at ");
                            thisTask = new Event(stamps[0].substring(6), eveWords[1]);
                            break;

                        case DEADLINE:
                            try {
                                if (words.length < 4 || stamps.length < 2) {
                                    throw new DukeException("The content of a deadline must be complete.");
                                }
                            } catch (DukeException exp) {
                                System.out.println(exp.toString() + "\n");
                                continue;
                            }
                            String[] ddlWords = input.split("/by ");
                            thisTask = new Deadline(stamps[0].substring(9), ddlWords[1]);
                            break;

                        default:
                            try {
                                throw new DukeException("I'm sorry, but I don't know what that means :-(");
                            } catch (DukeException exp) {
                                System.out.println(exp.toString() + "\n");
                                continue;
                            }
                    }

                    addItem(list, thisTask);
                    dukeStorage.writeToFile(list);
                    echo(thisTask);
                    System.out.println("     Now you have " + list.size() + " tasks in the list.\n" + Message.MESSAGE_LINE + "\n");
                }
            }

        }
    }*/

    /**
     * This method says goodbye to the user and quit the system.
     */
    public void exit() {
        textUi.showGoodBye();
        System.exit(0);
    }

    /**
     * This method echos whatever the user inputs.
     */
    /**
    public void echo(Task thisTask) {
        System.out.println(Message.MESSAGE_LINE);
        System.out.println(Message.MESSAGE_GOTIT);
        String directAnswer = "     " + thisTask.toString();
        System.out.println("  " + directAnswer);
    }*/

    /**
     * @param list
<<<<<<< HEAD
     * @param thisTask This method add a new task object to the array list.
=======
     * @param thisTask
     * This method adds a new task object to the array list.
>>>>>>> branch-Level-7
     */
    /**
    public void addItem(ArrayList<Task> list, Task thisTask) {
        list.add(thisTask);
    }*/

    /**
     * @param list This method displays the list of tasks.
     */
    /**
    public void displayList(ArrayList<Task> list) {
        System.out.println(Message.MESSAGE_LINE);
        System.out.println(Message.MESSAGE_SHOWLIST);
        int marker = 1;
        if (list.isEmpty()) {
            System.out.println(Message.MESSAGE_LINE + "\n");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println("     " + (i + 1) + ". " + list.get(i).toString());
            }
            System.out.println(Message.MESSAGE_LINE + "\n");
        }
    }*/
}
