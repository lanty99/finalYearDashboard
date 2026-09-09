import java.util.Scanner;

public class SimpleTaskManager {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Manager:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); //Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter task description: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(description);
                    break;
                case 2:
                    System.out.println("Task list: ");
                    taskManager.viewTasks();
                    break;
                case 3:
                    System.out.println("Enter task number to mark as done: ");
                    int completeIndex = scanner.nextInt();
                    taskManager.completeTask(completeIndex);
                    break;
                case 4:
                    System.out.println("Enter task number to delete: ");
                    int deleteIndex = scanner.nextInt();
                    taskManager.deleteTask(deleteIndex);
                    break;
                case 5:
                    System.out.println("Exiting Task Manager.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
