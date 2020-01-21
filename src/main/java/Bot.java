public class Bot {

    public Bot(){

    }

    public void staticResponse(StaticResponse responseType){
        switch( responseType ){
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

}









