class Task {
    int number;
    String name;
    boolean isDone;

    private Task(int number, String name, boolean isDone) {
        this.number = number;
        this.name = name;
        this.isDone = isDone;
    }

    public static Task createTask(int position, String name, boolean isDone) {
        return new Task(position, name, isDone);
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public String updatedDetails() {
        String checkbox = "[" + "\u2713" + "]";
        String result = checkbox + " " + this.getName();
        return result;
    }

    @Override
    public String toString() {
        String checkbox = "[" + (this.getIsDone() ? "\u2713" : "\u2718") + "]";
        String result = this.getNumber() + "." + checkbox + " " + this.getName();
        return result;
    }
}
