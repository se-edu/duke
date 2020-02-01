public interface Command {
    public void reply() throws DukeException;
    public boolean action() throws DukeException;
    public int getID();
}
