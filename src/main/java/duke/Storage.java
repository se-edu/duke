package duke;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Storage {
    private String filepath;
    private ArrayList<Task> tasks = new ArrayList<>();
    private int counter = 0;

    public Storage(String filepath) {
        this.filepath = filepath;
    }

    public ArrayList<Task> load() {
        try { //read file
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(" - ");
                if (temp[0].equals("T")) {
                    Task task = new Todo(temp[2]);
                    tasks.add(counter, task);
                    counter++;
                    if (Integer.parseInt(temp[1]) == 1) {
                        task.isDone = true;
                    }
                } else if (temp[0].equals("D")) {
                    int day = Integer.parseInt(temp[3].split("-")[2]);
                    int month = Integer.parseInt(temp[3].split("-")[1]);
                    int year = Integer.parseInt(temp[3].split("-")[0]);
                    LocalDate date = LocalDate.of(year, month, day);
                    Task task = new Deadline(temp[2], date);
                    tasks.add(counter, task);
                    counter++;
                    if (Integer.parseInt(temp[1]) == 1) {
                        task.isDone = true;
                    }
                } else if (temp[0].equals("E")) {
                    int day = Integer.parseInt(temp[3].split("-")[2]);
                    int month = Integer.parseInt(temp[3].split("-")[1]);
                    int year = Integer.parseInt(temp[3].split("-")[0]);
                    LocalDate date = LocalDate.of(year, month, day);
                    Task task = new Event (temp[2], date);
                    tasks.add(counter, task);
                    counter++;
                    if (Integer.parseInt(temp[1]) == 1) {
                        task.isDone = true;
                    }
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public void save(ArrayList<Task> toSave) {
        try { //write file
            FileWriter fileWriter = new FileWriter(filepath, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String content = "";
            for (Task task : toSave) {
                content = content + task.printToFile() + "\n";
            }
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
