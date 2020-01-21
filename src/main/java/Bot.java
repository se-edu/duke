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

    public void echo(String string){
        System.out.println(string);
    }

    public void res(String req){

        switch( req ){
            case "list":
                System.out.println(todo);
                break;
            case "done":
            default:
                this.todo.addTask(req);
        }


    }

}









