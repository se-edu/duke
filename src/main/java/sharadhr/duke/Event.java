package sharadhr.duke;

/**
 * Event
 */
public class Event extends Task
{
    protected String startTime;
    protected String endTime;
    protected String duration;

    // protected ZonedDateTime startTime;
    // protected ZonedDateTime endTime;

    private Event()
    {
        super();
        this.startTime = "";
        this.endTime = "";
    }

    public Event(String detail, String duration)
    {
        super(detail);
        this.duration = duration;
    }
    
    /**
     * Creates an Event with the specified detail, a beginning and an ending time.
     * @param detail The event detail.
     * @param start The start date/time of the event.
     * @param end The ending date/time of the event.
     */
    public Event(String detail, String start, String end)
    {
        this();
        this.startTime = start;
        this.endTime = end;
    }
    
    public char getTaskTypeIcon()
    {
        return 'E';
    }

    @Override
    public String toString()
    {
        return String.format("[%c]%s (at: %s)", this.getTaskTypeIcon(), super.toString(), this.duration);
        // return String.format("[%c]%s (from: %s to %s)", 
        //         this.getTaskTypeIcon(), super.toString(),
        //         this.startTime, this.endTime);
    }
}