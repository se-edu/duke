package common;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

import parser.FileParser;
import exception.DukeException;
import task.*;

public class Storage {

    private String filePath;

    public Storage (String filePath){
        this.filePath = filePath;
    }

    public ArrayList<Task> readFromFile() throws DukeException {
        try {
            String thisLine;
            ArrayList<Task> builtList = new ArrayList<>();
            File f = new File(this.filePath);
            Scanner fileScanner = new Scanner(f);
            while (fileScanner.hasNext()) {
                thisLine = fileScanner.nextLine();
                builtList.add(new FileParser(thisLine).lineToTask());
            }
            return builtList;
        } catch (IOException IOExp) {
            return new ArrayList<>();
        }
    }

    public void writeToFile(ArrayList<Task> existedList) throws DukeException {
        try {
            FileWriter fw = new FileWriter(this.filePath);
            for (Task task : existedList) {
                fw.write(task.toStringFileFormat() + "\n");
            }
            fw.close();
        } catch (IOException IOExp){
            System.out.println(IOExp);
            throw new DukeException("IOException detected");
        }

    }
}
