import java.io.IOException;

public class ByeCommand extends Command {

    public ByeCommand(Boolean isExit) {
        super(isExit);
    }

    /**
     * List of command to do when exiting the program.
     * @param tasklist tasklist loaded into storage.
     * @param ui Ui Prints exit message.
     * @param storage storage used to store data.
     * @return Returns a CommandResult object.
     */
    public CommandResult execute(TaskList tasklist, Ui ui, Storage storage) {
        try {
            ui.printGoodBye();
            storage.saveTask(tasklist);
            return new CommandResult("Successfully Executed");
        } catch (IOException ex) {
            return new CommandResult("IO Exception");
        }
    }

}
