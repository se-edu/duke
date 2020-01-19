public class Task {

    private String Title ="";
    private String Description = "";
    private String Datedue = "";
    private boolean status = true;

    Task(String s){
        Title = s;
    }

    @Override
    public String toString() {
        return Title;
    }
}
