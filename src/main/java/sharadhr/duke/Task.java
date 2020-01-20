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
public class Task
{
    // A list of tasks.
    protected static ArrayList<Task> tasks;

    protected String detail;
    protected boolean complete;

    /**
     * Initialises an empty {@link Task} that has an empty {@link String} as the detail,
     * and is set incomplete.
     */
    public Task()
    {
        this.detail = "";
        this.complete = false;
    }
    
    /**
     * Initialises a {@link Task} with some specified detail, and is set to incomplete.
     * @param name the task detail
     */
    public Task(String name)
    {
        this.detail = name;
        this.complete = false;
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
    public static boolean addTask(Task task) throws IOException
    {
        // Was the task successfully added to the list?
        boolean added = Task.tasks.add(task);
        
        if (added)
        {
            Duke.writer.append(String.format("added: %s%n", task)).flush();
        }
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
     */
    public static Task getTaskAtPosition(int position) throws IndexOutOfBoundsException
    {
        return getTaskAtIndex(position - 1);
    }

    /**
     * Prints the tasks in the list.
     * 
     * @throws IOException
     */
    public static void listTasks() throws IOException
    {
        if (!Task.tasks.isEmpty())
        {
            Duke.writer.append("Here are the tasks in your list:");
            Duke.writer.newLine();
            //Duke.writer.newLine();
            
            int listNumber = 1;
            for (Task task : Task.tasks)
            {
                Duke.writer.append(String.format("%d.%s%n", listNumber++, task));
            }
            Duke.writer.flush();
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
    public boolean markComplete() throws IOException
    {
        this.complete = true;

        Duke.writer.append("This task has been marked as done:" + 
                System.getProperty("line.separator")).append(this.toString());
        Duke.writer.newLine();
        Duke.writer.flush();
        return complete;
    }
    
    @Override
    public String toString()
    {
        return String.format("[%c]\t %s", this.getCompleteIcon(), this.detail);
    }
}