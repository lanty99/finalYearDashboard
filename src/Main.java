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

// In TaskManager — hands back the whole list
    public ArrayList<Task> getTasks() {
        return tasks;
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

    public boolean completeTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            return false;
        }
        tasks.get(index).markDone();
        return true;
    }

    public boolean deleteTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            return false;
        }
        tasks.remove(index);
        return true;
    }
}
