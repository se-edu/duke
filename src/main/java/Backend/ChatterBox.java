package Backend;

import java.util.List;

import Backend.Objects.Task.Task;

public class ChatterBox {

        public static String sayBye(){
            return "Type exit if u hate me!";
        }

        public static String sayNotFound(){
            return "Cannot find anything la";
        }

        public static String sayFound( List<Task> Tasks ){

            String str = "";

            for ( Task task: Tasks ){
                str += task.toString();
            }

            return str;

        }

        public static String sayMarkedTaskAsDone( Task task ){
            return "Good job!" + task.toString();
        }

        public static String sayNoCommandFound(){
            return "No command found";
        }

        public static String sayAddedTask( Task task ){
            return "Added Task!" + task.toString();
        }

        public static String sayRemovedTask( Task task ){
            return "Removed Task!" + task.toString();
        }

        public static String sayTaskList( List<Task> taskList ){

            if( taskList.size() == 0 ){
                return "You have no tasks in your list.";
            } else {

                StringBuilder str = new StringBuilder();
                str.append( "Here are your tasks sir:\n\n" );

                for( Task task: taskList ){
                    str.append( task.toString() ).append( "\n" );
                }

                return str.toString();
            }
        }
}
