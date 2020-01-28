package sharadhr.duke;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A Task class that allows creating a static list of tasks, that can be added to, 
 * iterated through and polled for contents, or deleted from. 
 * <p>
 * Also allows initialising an instance of a Task, which come with appropriate
 * instance methods.
 */
public abstract class Task
{
    // A list of tasks.
    protected static ArrayList<Task> tasks;

    protected String detail;
    protected boolean complete;

    Task()
    {
        this.detail = "";
        this.complete = false;
    }
    
    /**
     * Initialises a {@link Task} with some specified detail, and is set to incomplete.
     * @param name the task detail
     */
    public Task(String detail)
    {
        this();
        this.detail = detail;
    }

    /**
     * Initialises an {@link ArrayList} of tasks. 
     * 
     * @return {@code true} if list was successfully initialised
     */
    public static boolean createList()
    {
        tasks = new ArrayList<Task>();
        
        return !tasks.equals(null);
    }

    /**
     * Adds a task to the list.
     * 
     * @param task A task to be added to the list.
     * @return {@code true} if task was successfully added (as specified by
     *         {@link ArrayList#add})
     * @throws IOException
     */
    public static boolean addTask(Task task)
    {
        // Was the task successfully added to the list?
        boolean added = Task.tasks.add(task);

        Duke.writer.sayTaskAdded(task);
        return added;
    }
    
    static Task getTaskAtIndex(int index) throws IndexOutOfBoundsException
    {
        return tasks.get(index);
    }
    
    /**
     * Returns a task at {@code position}.
     * @param position The 1-indexed position of the task in the list
     * @return The task at the specified {@code position}
     * @throws IndexOutOfBoundsException if {@code position} 
     * ≥ size of tasks list + 1
     */
    public static Task getTaskAtPosition(int position) throws IndexOutOfBoundsException
    {
        return getTaskAtIndex(position - 1);
    }

    /**
     * 
     * @param parseInt
     * @return
     */
    public static void deleteTaskAtPosition(int position)
    {
        Duke.writer.sayTaskDeleted(getTaskAtPosition(position));
        tasks.remove(position - 1);
    }

    /**
     * Prints the tasks in the list.
     * 
     * @throws IOException
     */
    public static void listTasks()
    {
        if (!Task.tasks.isEmpty())
        {
            Duke.writer.say("Here are the tasks in your list:");

            int listNumber = 1;
            for (Task task : Task.tasks)
            {
                Duke.writer.add(String.format("%d.%s%n", listNumber++, task));
            }
            Duke.writer.say();
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////
    // Instance methods
    ////////////////////////////////////////////////////////////////////////////////////

    /**
     * Returns a character representing the completion state of this task.
     * 
     * @return {@code '✔'} if complete, {@code '✘'} otherwise
     */
    public char getCompleteIcon()
    {
        return complete ? '✔' : '✘';
    }
    
    /**
     * Marks this task as complete, and returns the state of the task (must be
     * {@code true}).
     * 
     * @return {@code true} if complete
     * @throws IOException
     */
    public boolean markComplete()
    {
        this.complete = true;
        Duke.writer.sayTaskMarkedComplete(this);

        return complete;
    }
    
    /**
     * Returns a character representing the type of Task (To-Do, Deadline, or Event)
     * 
     * @return the character representing the task type
     */
    public abstract char getTaskTypeIcon();
    
    @Override
    public String toString()
    {
        return String.format("[%c]\t %s", this.getCompleteIcon(), this.detail);
    }
}