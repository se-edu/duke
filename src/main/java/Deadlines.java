import java.time.LocalDateTime;
public class Deadlines extends Task {

    private LocalDateTime deadline;
    public Deadlines(String description) throws DukeException{
        super("default");

            String[] parsed = getParse(description);
            deadline = DateTimeHandler.getLocalDateTime(parsed[1]);
            super.resetDesc(parsed[0]);
    }

    private String[] getParse(String desc) throws DukeException{
        if(!desc.contains("/by ")){
            throw new DukeException("Hello? Missing your /by command!");
        }
        String[] parsed= desc.split("/by ");
        return parsed;
    }

    //format return book (by: Sunday)
    @Override
    public String toString() {
        return "[D] " +super.toString() + " (by: " + DateTimeHandler.printsLocalDateTime(deadline)+ ")";

    }
}
