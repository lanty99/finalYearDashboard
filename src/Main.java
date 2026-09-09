import java.util.ArrayList;

class Task {
    private String description;
    private boolean done;

    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void markDone() {
        this.done = true;
    }

    @Override
    public String toString() {
        return description + (!isDone() ? " [Pending]" : " [Complete]");
    }
}

class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String description) {
        tasks.add(new Task(description));
        System.out.println("Task added");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void completeTask(int index) {
        if (index < 1 || index > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }
        tasks.get(index - 1).markDone();
        System.out.println("Task completed");
    }

    public void deleteTask(int index) {
        if (index < 1 || index > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }
        tasks.remove(index - 1);
        System.out.println("Task deleted");
    }
}
