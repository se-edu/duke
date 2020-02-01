import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static int counter = 0;
    private static ArrayList<Task> tasklist = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hey, I'm Duke");
        System.out.println("What's up");

        try { //read file
            FileReader fileReader = new FileReader("data/duke.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(" - ");
                if (temp[0].equals("T")) {
                    Task task = new Todo(temp[2]);
                    tasklist.add(counter, task);
                    counter++;
                    if (Integer.parseInt(temp[1]) == 1) {
                        task.isDone = true;
                    }
                } else if (temp[0].equals("D")) {
                    int day = Integer.parseInt(temp[3].split("-")[2]);
                    int month = Integer.parseInt(temp[3].split("-")[1]);
                    int year = Integer.parseInt(temp[3].split("-")[0]);
                    LocalDate date = LocalDate.of(year, month, day);
                    Task task = new Deadline(temp[2], date);
                    tasklist.add(counter, task);
                    counter++;
                    if (Integer.parseInt(temp[1]) == 1) {
                        task.isDone = true;
                    }
                } else if (temp[0].equals("E")) {
                    int day = Integer.parseInt(temp[3].split("-")[2]);
                    int month = Integer.parseInt(temp[3].split("-")[1]);
                    int year = Integer.parseInt(temp[3].split("-")[0]);
                    LocalDate date = LocalDate.of(year, month, day);
                    Task task = new Deadline(temp[2], date);
                    tasklist.add(counter, task);
                    counter++;
                    if (Integer.parseInt(temp[1]) == 1) {
                        task.isDone = true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String nextString = scanner.nextLine();
            if (nextString.equals("bye")) {
                System.out.println("Bye.");
                break;
            } else if (nextString.equals("list")) {
                System.out.println("Here are the tasks in your list: ");
                for (Task t : tasklist) {
//                    if(t.type.equals("D")) {
//                        System.out.println((tasklist.indexOf(t) + 1) + ". " + t.printInList());
//                    }
                    System.out.println((tasklist.indexOf(t) + 1) + ". " + t.toString());
                }
            } else if (nextString.contains("done")) {
                String[] temp = nextString.split(" ");
                int index = Integer.parseInt(temp[1]) - 1;
                System.out.println("Nice! I've marked this task as done: ");
                Task current = tasklist.get(index);
                current.isDone = true;
                System.out.println(current.toString());
            } else if (nextString.contains("todo")) {
                try {
                    if (nextString.equals("todo")) {
                        throw new DukeException("OOPS!!! The description of a todo cannot be empty :(");
                    }
                    String name = nextString.substring(5);
                    Task task = new Todo(name);
                    tasklist.add(counter, task);
                    counter++;
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("  " + task.toString());
                    System.out.println("Now you have " + (counter) + " tasks in your list.");
                } catch (DukeException ex) {
                    System.out.println("Oops, ");
                }
            } else if (nextString.contains("deadline")) {
                try {
                    if (nextString.equals("deadline")) {
                        throw new DukeException("OOPS!!! The description of a deadline cannot be empty :(");
                    } else if (!nextString.contains("/by")) {
                        throw new DukeException("Did you mistype something?");
                    }
                    String name = nextString.substring(9);
                    String taskName = name.split(" /by ")[0];
                    String dateTime = name.split(" /by ")[1];

                    String[] tempDate = dateTime.split(" ");
                    int day = Integer.parseInt(tempDate[0].split("/")[0]);
                    int month = Integer.parseInt(tempDate[0].split("/")[1]);
                    int year = Integer.parseInt(tempDate[0].split("/")[2]);
                    LocalDate date = LocalDate.of(year, month, day);
                    Task task = new Deadline(taskName, date);

                    tasklist.add(counter, task);
                    counter++;
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("  " + task.toString());
                    System.out.println("Now you have " + (counter) + " tasks in your list.");
                } catch (DukeException ex) {
                    ex.printStackTrace();
                }
            } else if (nextString.contains("event")) {
                try {
                    if (nextString.equals("event")) {
                        throw new DukeException("OOPS!!! The description of an event cannot be empty :(");
                    } else if (!nextString.contains("/at")) {
                        throw new DukeException("Did you mistype something?");
                    }
                    String name = nextString.substring(5);

                    String taskName = name.split(" /at ")[0];
                    String dateTime = name.split(" /at ")[1];

                    String[] tempDate = dateTime.split(" ");
                    int day = Integer.parseInt(tempDate[0].split("/")[0]);
                    int month = Integer.parseInt(tempDate[0].split("/")[1]);
                    int year = Integer.parseInt(tempDate[0].split("/")[2]);
                    LocalDate date = LocalDate.of(year, month, day);
                    Task task = new Event(taskName, date);

                    tasklist.add(counter, task);
                    counter++;
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("  " + task.toString());
                    System.out.println("Now you have " + (counter) + " tasks in your list.");
                } catch (DukeException ex) {
                    ex.printStackTrace();
                }
            } else if (nextString.contains("delete")) {
                try {
                    if (nextString.equals("delete")) {
                        throw new DukeException("OOPS!!! There's no event to be deleted :(");
                    }
                    String[] temp = nextString.split(" ");
                    int index = Integer.parseInt(temp[1]) - 1;
                    System.out.println("Noted! I've removed this task: ");
                    Task current = tasklist.get(index);
                    tasklist.remove(index);
                    System.out.println(current.toString());
                    counter--;
                    System.out.println("Now you have " + (counter) + " tasks in your list.");
                } catch (DukeException ex) {
                    ex.printStackTrace();
                }
            } else {
                try {
                    throw new DukeException("I'm sorry, I don't understand :(");
                } catch (DukeException e) {
                    e.printStackTrace();
                }
            }
        }

        try { //write file
            FileWriter fileWriter = new FileWriter("data/duke.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String content = "";
            for (Task task : tasklist) {
                content = content + task.printToFile() + "\n";
            }
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
