package duke.parser;

import duke.command.AddCommand;
import duke.command.ByeCommand;
import duke.command.Command;
import duke.command.DeleteCommand;
import duke.command.DisplayTaskCommand;
import duke.command.DoneCommand;
import duke.command.FindCommand;
import duke.command.IncorrectCommand;
import duke.command.InstructionCommand;
import duke.exception.DukeException;
import duke.task.Deadlines;
import duke.task.Symbol;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.Todo;
import duke.task.Event;

import java.util.Arrays;

public class Parser {
    /**
     * Process message and deem if user wants to quit.
     * Print good bye message if user wants to quit.
     * Else echo back the message the user inputted
     * @param message entered by user.
     * @return boolean used to inform other function if user wants to quit
     *     true -> continue using bot, false -> quit bot.
     */
    public static Command parseMessage(String message) throws DukeException {
        try {
            Task temp;
            if (message.equals("bye")) {
                return new ByeCommand(true);
            } else if (message.equals("i")) {
                return new InstructionCommand();
            } else if (message.equals("list")) {
                return new DisplayTaskCommand();
            } else if (message.substring(0, 4).equals("done")) {
                int taskIndex = Integer.parseInt(message.split(" ", 2)[1]);
                return new DoneCommand(taskIndex);
            } else if (message.substring(0, 4).equals("todo")) {
                temp = createTask(message, Symbol.T);
                return new AddCommand(temp);
            } else if (message.substring(0, 4).equals("find")) {
                String find = message.split(" ",2)[1];
                return new FindCommand(find);
            } else if (message.substring(0, 5).equals("event")) {
                temp = createTask(message, Symbol.T);
                return new AddCommand(temp);
            } else if (message.substring(0, 8).equals("deadline")) {
                temp = createTask(message, Symbol.T);
                return new AddCommand(temp);
            } else if (message.substring(0, 6).equals("delete")) {
                int taskIndex = Integer.parseInt(message.split(" ", 2)[1]);
                return new DeleteCommand(taskIndex);
            } else {
                throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        } catch (StringIndexOutOfBoundsException ex) {
            return new IncorrectCommand("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }

    /**
     * Creates task.
     * @param message use to store it in the tasks.
     */
    public static Task createTask(String message, Symbol symbol) throws DukeException {
        String[] arrMessage = message.split(" ");
        Task task;
        if (symbol == Symbol.T) {
            String[] tempArr = Arrays.copyOfRange(arrMessage,1,arrMessage.length);
            String newMessage = String.join(" ", tempArr);
            task = new Todo(newMessage, TaskList.index);
        } else if (symbol == Symbol.D) {
            int landmark = arrMessage.length;
            for (int i = 1; i < arrMessage.length; i++) {
                if (arrMessage[i].equals("/by")) {
                    landmark = i;
                    break;
                }
            }
            if (landmark == arrMessage.length) {
                throw new DukeException("  ☹ OOPS!!! The description of a deadline cannot be empty.");
            }
            String[] tempArr = Arrays.copyOfRange(arrMessage, 1, landmark);
            String[] tempArr2 = Arrays.copyOfRange(arrMessage, landmark + 1, arrMessage.length);
            String newMessage = String.join(" ", tempArr);
            String newDate = String.join(" ", tempArr2);
            task = new Deadlines(newMessage, TaskList.index, symbol, newDate);
        } else {
            int landmark = arrMessage.length;
            for (int i = 1; i < arrMessage.length; i++) {
                if (arrMessage[i].equals("/at")) {
                    landmark = i;
                    break;
                }
            }
            if (landmark == arrMessage.length) {
                throw new DukeException("  ☹ OOPS!!! The description of a event cannot be empty.");
            }
            String[] tempArr = Arrays.copyOfRange(arrMessage, 1, landmark);
            String[] tempArr2 = Arrays.copyOfRange(arrMessage, landmark + 1, arrMessage.length);
            String newMessage = String.join(" ", tempArr);
            String newDate = String.join(" ", tempArr2);
            task = new Event(newMessage, TaskList.index, newDate);
        }
        return task;
    }
}
