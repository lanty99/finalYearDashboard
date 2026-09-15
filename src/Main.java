import java.util.ArrayList;
import java.io.*;

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
    private static final String FILE_NAME = "tasks.txt";

    public TaskManager() {
        loadTasks(); // load saved tasks as soon as a TaskManager is created
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
        System.out.println("Task added");
        saveTasks();
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
        saveTasks();
        return true;
    }

    public boolean deleteTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            return false;
        }
        tasks.remove(index);
        saveTasks();
        return true;
    }

private void saveTasks() {
    try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
        for (Task t : tasks) {
            writer.println(t.getDescription() + "|" + t.isDone());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    private void loadTasks() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return; // no saved file yet — nothing to load
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|", 2); // split into at most 2 pieces
                if (parts.length == 2) {
                    Task t = new Task(parts[0]);
                    if (Boolean.parseBoolean(parts[1])) {
                        t.markDone();
                    }
                    tasks.add(t);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
