package Backend;

import Backend.Exceptions.DukeException;
import Backend.Objects.Task.Deadline;
import Backend.Objects.Task.Event;
import Backend.Objects.Task.Todo;
import Backend.Parsers.DateParser;
import Backend.Parsers.Parser;
import Backend.Objects.Task.Task;

import java.util.Optional;

public class Switcher {

    private TaskList taskList;

    public Switcher( TaskList taskList ){
        this.taskList = taskList;
    }

    /**
     * switches on command and decides what is printed
     * @param req user input
     * @throws DukeException
     */
    public String res(String req) throws DukeException {

        if( req.equals( "exit" )){
            return ChatterBox.sayExit();
        }

        if( req.equals("bye") ){
            return ChatterBox.sayBye();
        }

        try {
            Parser parser = new Parser(req);
            String command = parser.parseCommand();

            /**
             * commands that have to do with printing
             */
            switch( command ){
                case "help":
                    return ChatterBox.sayHelp();
                case "list":
                    return taskList.printTasks();
                case "date":
                    return taskList.printTasks(req);
                case "find":
                    return taskList.findTask(req);
            }

            Optional<Integer> indexOptional = parser.parseContentAsInt();

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
                default:
                    String content = parser.parseContent();
                    Task task;

                    switch( command ) {
                        case "event":
                            task = new Event( content, new DateParser(parser.parseDateString() ));
                            break;
                        case "deadline":
                            task = new Deadline(content, new DateParser(parser.parseDateString()));
                            break;
                        case "todo":
                            task = new Todo( content );
                            break;
                        default:
                            throw new DukeException( new StringIndexOutOfBoundsException()  );
                    }

                    taskList.addTask(task);
                    return ChatterBox.sayAddedTask( task );
            }

        } catch (StringIndexOutOfBoundsException e){

                throw new DukeException(e);

        }



    }

}









