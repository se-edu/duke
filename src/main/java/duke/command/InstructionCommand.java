package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class InstructionCommand extends Command {
    private final String success = "Success";

    public InstructionCommand() {
    }

    public InstructionCommand(Boolean isExit) {
        super(isExit);
    }

    /**
     * Prints list of Commands.
     * @param tasks not used.
     * @param ui Prints commands
     * @param storage not used.
     * @return returns duke.command.CommandResult
     */
    public CommandResult execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            ui.botInstruction();
            return new CommandResult(success);
        } catch (Exception ex) {
            return new CommandResult(ex.getMessage());
        }
    }
}
