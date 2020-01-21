import java.util.List;
import java.util.ArrayList;

public class Bot {

    TodoList todo;

    public Bot(){
        this.todo = new TodoList();
    }

    public void staticResponse(StaticReq reqType){
        switch( reqType ){
            case SAYGOODBYE:
                System.out.println("Catch you later!");
                break;
            case SAYHELLO:
                System.out.println("Hi! How may I help you?");
                break;
            default:
        }
    }

    private static String removeNonAlphabetical(String string){

        String _string = "";

        char[] charArray = string.toCharArray();

        for( char c : charArray ){

            if( (int)c > 97 && (int)c < 123 ){
                _string += c;
            }
        }

        return _string;

    }

    private static int getFirstInteger(String string){

        char[] charArray = string.toCharArray();

        for( char c: charArray ){
            if((int)c > 47 && (int)c < 58){
                return Character.getNumericValue(c);
            }
        }

        return 0;

    }

    public void echo(String string){
        System.out.println(string);
    }

    public void res(String req){

        String command = removeNonAlphabetical(req);

        switch( command ){
            case "list":
                System.out.println(todo);
                break;
            case "done":
                int index = getFirstInteger(req);
                this.todo.markTask(index);
                break;
            default:
                this.todo.addTask(req);
        }


    }

}









