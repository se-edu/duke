/*
*  "Memory/Storage"
*
* */



import java.io.*;
import java.util.ArrayList;

public class Bot_Memory {
    private static File file;

    public static void memory_Init(){
        try{
            file = new File("memory.txt");
            if (file.createNewFile()) {
                System.out.println("Init new memory");
            }
            else{
                System.out.println("\nPrevious data found, Loading memory...\n");
                loadMemory();

            }
        }
        catch (IOException e){
        }
    }


    private static void overwrite(String line){

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file,false));
            bw.write(line);
            bw.newLine();
            bw.flush();
            bw.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static void append(String line){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
            bw.write(line);
            bw.newLine();
            bw.flush();
            bw.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void saveMemory() throws DukeException{
        ArrayList<Task> mylist = MyList.getList();
        boolean first = true;

        for(Task t: mylist){
            String splitted[] = t.toString().split(" ", 3);
            String type = parseType(splitted[0]);
            String isDone = parseDone(splitted[1]);
            String desc = parseDesc(splitted[2]);
            String buildLine = type+ "~" + isDone + "~" + desc;
            if(first){
                first = false;
                overwrite(buildLine);
                continue;
            }
            append(buildLine);
        }
    }

    private static String parseType(String s) throws DukeException{
        if(s.equals("[D]")){
            return "deadline";
        }
        else if(s.equals("[E]")){
            return "event";
        }
        else if(s.equals("[T]")){
            return "todo";
        }
        else{
            throw new DukeException("Invalid file parsed error! Please delete the memory file..");
        }
    }

    private static String parseDone(String s){
        if(s.equals("[\u2713]")){
            return "true";
        }
        else{
            return "false";
        }
    }

    private static String parseDesc(String str){
        if(!str.contains("(")){
            return str;
        }
        String typeSpecific = str.substring(str.indexOf("(")+1,str.indexOf(":"));
        String desc = str.substring(0,str.indexOf("(") -1 );
        String datedesc = str.substring(str.indexOf(":")+2,str.indexOf(")"));
        return desc + "/" + typeSpecific + " " + datedesc;

    }

//Load_Command(String type, boolean setDone,String desc)
    private static void loadMemory(){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
               // System.out.println(line);
                boolean markdone;
                String splitted[] = line.split("~");
                if(splitted[1].equals("false")){
                    markdone= false;
                }
                else{
                    markdone = true;
                }
                CommandInvoker.Invoke(new Load_Command(splitted[0],markdone,splitted[2]));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
