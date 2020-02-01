public class DeleteCommand extends Command {
    private final int taskIndex;
    private final String success = "Task has been removed";

    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    public DeleteCommand(Boolean isExit, int taskIndex) {
        super(isExit);
        this.taskIndex = taskIndex;
    }

    /**
     * Deletes task base on taskIndex.
     * Saves task in txt file.
     * @param taskList taskList is updated with the deleted task.
     * @param ui Ui prints delete task message back to user.
     * @param storage Storage updates the txt file with updated taskList.
     * @return returns CommandResult.
     */
    public CommandResult execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            Task temp = taskList.deleteTask(taskIndex);
            storage.saveTask(taskList);
            ui.deleteTaskSuccess(temp);
            return new CommandResult(success);
        } catch (Exception ex) {
            return new CommandResult(ex.getMessage());
        }
    }

}
