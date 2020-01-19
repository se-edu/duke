public class EventCreator {
    EventCreator(String ID){
        Create(ID);
    };
    public static UserCommand Create(String ID){
        UserCommand us = null;
        if(ID.equals("bye")){
            us = new Bye();
        }


        return us;

    }}
