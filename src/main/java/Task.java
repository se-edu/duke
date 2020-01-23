public class Task {
    String name;
    boolean isDone;

    Task(String name, boolean isDone) {
        this.name = name;
        this.isDone = isDone;
    }

    public static Task createTask(String name, boolean isDone) {
        return new Task(name, isDone);
    }

    public String getName() {
        return name;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public Task complete() {
        return createTask(this.getName(), true);
    }

    @Override
    public String toString() {
        String checkbox = "[" + (this.getIsDone() ? "\u2713" : "\u2718") + "]";
        String result = checkbox + " " + this.getName();
        return result;
    }
}
