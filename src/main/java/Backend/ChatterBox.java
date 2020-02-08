package Backend;

import java.util.List;

import Backend.Objects.Task.Task;
import Backend.Parsers.DateParser;
import Backend.Parsers.TimeOfDay;

/**
 * A utility class for storing and returning responses
 */
public class ChatterBox {

        public static String sayHello(){
            TimeOfDay timeOfDay =  DateParser.getTimeOfDay();

            switch ( timeOfDay ){
                case MORNING:
                    return "Good morning sir. Hope you slept well.";
                case AFTERNOON:
                    return "Good afternoon sir. Had your lunch?";
                case NIGHT:
                    return "Good evening sir. Hope you had a great day.";
            }

            return "";
        }

        public static String sayBye(){
            return "If you really have to leave sir, please type 'exit'.";
        }

        public static String sayExit(){
            return "I'll be here eagerly waiting your arrival. Goodbye.";
        }

        public static String sayNotFound(){
            return "I looked long and hard but couldn't find what you were looking for. A different search term perhaps?";
        }

        public static String sayFound( List<Task> Tasks ){

            StringBuilder str = new StringBuilder();

            for ( Task task: Tasks ){
                str.append( task.toString() );
            }

            return str.toString();

        }

        public static String sayMarkedTaskAsDone( Task task ){
            return "Good job!" + task.toString();
        }

        public static String sayAddedTask( Task task ){
            return "Nicely done sir. I've added your task.\n" + task.toString();
        }

        public static String sayRemovedTask( Task task ){
            return "I assume you've completed this sir... I've removed it from the list.\n" + task.toString();
        }

        public static String sayTaskList( List<Task> list ){

            if( list.size() == 0 ){
                return "You currently have no tasks sir.";
            } else {

                StringBuilder str = new StringBuilder();
                str.append( "Here are your tasks sir:\n" );

                for( Task task: list ){
                    str.append( task.toString() ).append( "\n" );
                }

                return str.toString();
            }
        }
}
