import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

import task.*;

public class Storage {

    private String filePath;

    public Storage (String filePath){
        this.filePath = filePath;
    }

    public ArrayList<Task> readFromFile() throws DukeException {
        try {
            String thisLine = "";
            ArrayList<Task> builtList = new ArrayList<>();
            File f = new File(this.filePath);
            Scanner fileScanner = new Scanner(f);
            while (fileScanner.hasNext()) {
                thisLine = fileScanner.nextLine();
                builtList.add(new Parser(thisLine).lineToTask());
            }
            return builtList;
        } catch (IOException IOExp) {
            if(IOExp instanceof FileNotFoundException){
                return new ArrayList<Task>();
            } else {
                throw new DukeException("IOException detected.");
            }
        }
    }

    public void writeToFile(ArrayList<Task> existedList) throws DukeException {

        try {
            FileWriter fw = new FileWriter(this.filePath);
            for (int i = 0; i < existedList.size(); i++) {
                fw.write(existedList.get(i).toStringFileFormat() + "\n");
            }
            fw.close();
        } catch (IOException IOExp){
            System.out.println(IOExp);
            throw new DukeException ("IOException detected");
        }

    }
}
