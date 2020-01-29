package parser;

import task.*;

public class FileParser {

    private String thisLine;

    public FileParser(String str){
        this.thisLine = str.trim();
    }

    public Task lineToTask(){

        String[] words = this.thisLine.split(" \\| ");

        boolean isDone = false;
        if(words[1].trim().equals("1")){
            isDone = true;
        } else {
            isDone = false;
        }
       // D | 0 | return book | June 6th
        String name = words[2].trim();
        String duration = "";

        String category = words[0].trim();
        switch(category) {
            case "T":
                return new Todo(name, isDone);
            case "E":
                duration = words[3];
                return new Event(name, duration, isDone);
            case "D":
                duration = words[3];
                return new Deadline(name, duration, isDone);
            default:
                return new Task(name, isDone);
        }

    }

}
