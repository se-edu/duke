package sharadhr.duke;

/**
 * A Deadline, with a date to be done by.
 */
public class Deadline extends Task
{
    String byString;
    
    private Deadline()
    {
        super();
    }
    
    /**
     * Creates a {@link Deadline} with no detail, and a date-time to be done by.
     * 
     * @param by A date-time of the deadline itself
     */
    Deadline(String by)
    {
        this();
        this.byString = by;
        
        // this.by = ZonedDateTime.of(
        // LocalDate.parse(tokens[0], DateTimeFormatter.ofPattern("dd/MM/uuuu")),
        // LocalTime.parse(tokens[1], DateTimeFormatter.ofPattern("ha")), 
        // ZoneId.systemDefault());
    }
    
    /**
     * Creates a deadline with a specified detail, and a date-time to be done by.
     * @param detail The deadline detail
     * @param by the date-time to be done by
     */
    public Deadline(String detail, String by)
    {
        this(by);
        this.detail = detail;
    }
    
    @Override
    public char getTaskTypeIcon()
    {
        return 'D';
    }
    
    @Override
    public String toString()
    {
        return String.format("[%c]%s (by: %s)", this.getTaskTypeIcon(), super.toString(),
                this.byString);
    }
}