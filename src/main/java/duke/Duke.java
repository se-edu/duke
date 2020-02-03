package duke;

import java.util.ArrayList;
import java.util.Scanner;

/** Simulates a personal assistant chatbot.
 * called Duke that acts as a reminder
 *
 */
public class Duke {
    private static int counter = 0;

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /** Creates a new instance of Duke.
     * @param filePath represents the file path
     *     of the file that is being read and written
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
    }

    /** Runs the program.
     */
    public void run() {
        ui.greet();
        ArrayList<Task> tasklist = storage.load();
        counter = tasklist.size();
        tasks = new TaskList(tasklist, counter);

        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser(tasklist, counter);
        String nextString;
        while (scanner.hasNext()) {
            nextString = scanner.nextLine();
            if (nextString.equals("bye")) {
                System.out.println(ui.sayBye());
                break;
            } else {
                parser.parseCommand(nextString, tasks);
            }
        }
        storage.save(tasklist);
    }

    public static void main(String[] args) {
        new Duke("data/duke.txt").run();
    }
}
