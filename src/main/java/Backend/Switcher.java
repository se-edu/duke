package Backend;

import Backend.Exceptions.DukeException;
import Backend.Parsers.Parser;
import Backend.Objects.Task.Task;

import java.util.Optional;

public class Switcher {

    TaskList taskList;

    public Switcher( TaskList taskList ){
        this.taskList = taskList;
    }

    /**
     * switches on command and decides what is printed
     * @param req user input
     * @throws DukeException
     */
    public String res(String req) throws DukeException {

        if( req.equals("exit")){
            System.exit(0);
        }

        if( req.equals("bye") ){
            return ChatterBox.sayBye();
        }

        try {
            Parser parser = new Parser(req);
            String command = parser.getCommand();

            /**
             * commands that have to do with printing
             */
            switch( command ){
                case "list":
                    return taskList.printTasks();
                case "date":
                    return taskList.printTasks(req);
                case "find":
                    return taskList.findTask(req);
            }

            Optional<Integer> indexOptional = parser.getContentAsInt();

            int index = 0;

            if( indexOptional.isPresent() ){
                index = indexOptional.get();
            }

            /**
             * functional commands
             */
            switch( command ) {
                case "done":
                    Task markedTask = taskList.markTask( index );
                    return ChatterBox.sayMarkedTaskAsDone( markedTask );
                case "delete":
                    Task removedTask = taskList.deleteTask(index);
                    return ChatterBox.sayRemovedTask(removedTask);
                case "todo":
                    Task addedTask = taskList.addTask(req);
                    return ChatterBox.sayAddedTask(addedTask);
                default:
                    return ChatterBox.sayNoCommandFound();
            }


        } catch (StringIndexOutOfBoundsException e){

                throw new DukeException(e);

        }



    }

}









