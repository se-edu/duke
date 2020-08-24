public class Task {
	protected String description;
	protected Boolean isDone;

	public Task(String description) {
		this.description = description;
		this.isDone = false;
	}

	public String getStatusIcon() {
		return (isDone ? "[" + "\u2713" + "]" : "[" + "\u2718" + "]"); //returns [tick] or [X] symbols
	}

	public void markAsDone() {
		this.isDone = true;
	}
}
