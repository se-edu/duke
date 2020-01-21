

public class Task {

    private String description;
    private boolean completed;

    public Task( String description) {
        this.description = description;
        this.completed = false;

    }

    public void completedTask() {
        this.completed = true;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        if (this.completed) {
            return ("[✓] " + this.description);
        } else {
            return ("[✗]" + this.description);
        }
    }

}
