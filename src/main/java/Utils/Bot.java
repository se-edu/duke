package Utils;

import Task.TaskList;
import Task.DukeException;

import java.util.Optional;

public class Bot {

    TaskList taskList;

    public Bot(){
        try {
            this.taskList = new TaskList(Storage.loadFromFile());
        } catch ( DukeException e ){
            this.taskList = new TaskList();
        }

    }

    /**
     * switches on command and decides what is printed
     * @param req user input
     * @throws DukeException
     */
    public String res(String req) throws DukeException {

        try {
            Parser parser = new Parser(req);
            String command = parser.getCommand();

            if( command.equals("list")){
                return taskList.printTasks();
            } else if (command.equals("date")){
                return taskList.printTasksOn(req);
            } else {
                Optional<Integer> indexOptional = parser.getContentAsInt();

                int index = 0;

                if( indexOptional.isPresent() ){
                    index = indexOptional.get();
                }

                switch( command ) {
                    case "done":
                        return taskList.markTask(index);
    //                    break;
                    case "delete":
                        return taskList.deleteTask(index);
    //                    break;
                    default:
                        return taskList.addTask(req);
                }
            }

        } catch (StringIndexOutOfBoundsException e){

                throw new DukeException( "Invalid command!" );

        }


<<<<<<< HEAD
=======
            switch( command ) {
                case "done":
                    taskList.markTask(index);
                    break;
                case "delete":
                    taskList.deleteTask(index);
                    break;
                case "find":
                    taskList.findTask(req);
                    break;
                default:
                    taskList.addTask(req);
            }
        }
>>>>>>> c34ef0d6afcb62c9cd22062400d2418ff58d69dc

    }

}









