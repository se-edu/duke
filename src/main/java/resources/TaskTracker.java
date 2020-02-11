package resources;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Tracks the task's activity
 */
public class TaskTracker {

    private static ArrayList<Task> listOfDoneTasksWeek = new ArrayList<>();
    private static int currentWeek = 0;

    /**
     * Adds a task that is finish into the list
     * Updates the current week
     *
     * @param t the task to add
     */
    public static void finishTask(Task t) {
        //update current week
        currentWeek = getWeek(LocalDate.now());
        //Check if list of donetask is still in same week
        updateDone();
        //insert
        listOfDoneTasksWeek.add(t);
    }

    /**
     * Returns completed things this week
     *
     * @return String of things done this week
     */
    public static String doneThisWeek() {
        updateDone();
        String ans = "" + printList(listOfDoneTasksWeek);
        return ans + "You have completed "
                + listOfDoneTasksWeek.size() + " things this week\n";
    }

    /**
     * Returns number of items done this week
     *
     * @return  int the task to add
     */
    public static int done() {
        return listOfDoneTasksWeek.size();
    }


    private static String printList(ArrayList<Task> list) {
        String ans = "";
        if (list.size() != 0) {
            ans = "Task done this week: \n";
        }
        int count =  1;
        for (Task t : list) {
            ans =  ans + count + ". " + t + "\n";
            count++;
        }
        return ans;
    }


    private static void updateDone() {
        ArrayList<Task> newDoneTasks = new ArrayList<>();
        for (Task task: listOfDoneTasksWeek) {
            if (isSameWeekAsToday(task.getDoneDate())) {
                newDoneTasks.add(task);
            }
        }
        listOfDoneTasksWeek = newDoneTasks;
    }

    private static boolean isSameWeekAsToday(LocalDate d) {
        int todayWeek = getWeek(d);
        return todayWeek == currentWeek;
    }

    //part of code snippet found at https://stackoverflow.com/questions/26012434/get-week-number-of-localdate-java-8/26013129
    private static int getWeek(LocalDate d) {
        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        int todayWeekNum = d.get(woy);
        return todayWeekNum;
    }
}
