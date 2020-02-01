import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static int counter;

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
    }

    public void run() {
        ui.greet();
        ArrayList<Task> tasklist = storage.load();
        tasks = new TaskList(tasklist);
        counter = tasklist.size();

        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser(tasklist);
        String nextString = "";
        while (scanner.hasNext() && !nextString.equals("bye")) {
             nextString= scanner.nextLine();
            parser.parseCommand(nextString, tasks, counter);
        }
        storage.save(tasklist);
    }

    public static void main(String[] args) {
        new Duke("data/duke.txt").run();
    }
}
