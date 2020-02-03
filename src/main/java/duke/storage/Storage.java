package duke.storage;

import duke.exception.DukeException;
import duke.task.Deadlines;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.Todo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Storage {
    private java.nio.file.Path path;

    public Storage(Path path) {
        this.path = path;
    }

    /**
     * Load task from a txt file.
     * @throws IOException Throw exception if no file detected.
     */
    public TreeMap<Integer, Task> load() throws DukeException {
        try {
            File file = this.path.toFile();
            Scanner scanner = new Scanner(file);
            TreeMap<Integer, Task> tasksTemp = new TreeMap<>();
            int counter = 1;
            while (scanner.hasNextLine()) {
                Task task;
                boolean don = false;
                String data = scanner.nextLine();
                String[] arrMessage = data.split("\\|");
                if (arrMessage[1].equals("1")) {
                    don = true;
                }
                if (arrMessage[0].equals("T")) {
                    task = new Todo(arrMessage[2], counter, don);
                    tasksTemp.put(counter, task);
                } else if (arrMessage[0].equals("D")) {
                    task = new Deadlines(arrMessage[2], counter, don, arrMessage[3]);
                    tasksTemp.put(counter, task);
                } else if (arrMessage[0].equals("E")) {
                    task = new Event(arrMessage[2], counter, don, arrMessage[3]);
                    tasksTemp.put(counter, task);
                }
                counter++;
            }
            return tasksTemp;
        } catch (IOException e) {
            throw new DukeException("There was a error when loading the data");
        }
    }


    /**
     * Saves task in txt doc.
     * @param tasksList taskList use to get the latest task.
     * @throws IOException Handle IOexception associated to fileWriter.
     */
    public void saveTask(TaskList tasksList) throws IOException {
        TreeMap<Integer, Task> tasks = tasksList.getList();
        File file = this.path.toFile();
        FileWriter writer = new FileWriter(file);
        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            Task task = entry.getValue();
            String message = task.getInfo();
            writer.write(message + "\n");
        }
        writer.close();
    }
}
