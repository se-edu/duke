package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * InstructionCommand inherits from Command class.
 * Implements abstract method execute.
 * @author Lua Jia Zheng.
 */
public class InstructionCommand extends Command {
    static final String SUCCESS = "Success";

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
            return new CommandResult(SUCCESS);
        } catch (Exception ex) {
            return new CommandResult(ex.getMessage());
        }
    }
}
