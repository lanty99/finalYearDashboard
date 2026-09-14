
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class TaskManagerGUI {

        public static void main(String[] args) {
            JFrame frame = new JFrame("Final-Year Dashboard");
            // 400 width and 500 height
            frame.setSize(500, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // ---- Background panel, set as content pane BEFORE adding anything else ----
            JPanel backgroundPanel = new JPanel() {
                private BufferedImage image;
                {
                    try {
                        image = ImageIO.read(new File("src/images/background.jpg"));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    //g.setColor(Color.RED);
                    //g.fillRect(0, 0, getWidth(), getHeight()); // test: does ANY custom painting show?
                    if (image != null) {
                        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                    }

                }
            };
            backgroundPanel.setLayout(null); // keep using setBounds like before
            frame.setContentPane(backgroundPanel);


            frame.setTitle("Task Dashboard");
            TaskManager taskManager = new TaskManager(); // reuse your existing class


            // ---- Button 1: Add Task ----
            // Creating instance of JButton
            JButton addTaskButton = new JButton(" Add Task ");
            // adding button in JFrame
            frame.add(addTaskButton);
            // x axis, y axis, width, height
            addTaskButton.setBounds(140, 50, 220, 50);


            addTaskButton.addActionListener(e -> {
                        String description = JOptionPane.showInputDialog(frame, "Enter task description:", "Add Task", JOptionPane.PLAIN_MESSAGE);
                        if (description != null && !description.trim().isEmpty()) {
                            taskManager.addTask(description);
                        }
                    });

            // ---- Button 2: View Tasks ----
            // Creating instance of JButton
            JButton viewTasksButton = new JButton(" View Tasks ");
            // adding button in JFrame
            frame.add(viewTasksButton);
            // x axis, y axis, width, height
            viewTasksButton.setBounds(140, 100, 220, 50);

            viewTasksButton.addActionListener(e -> {
                ArrayList<Task> tasks = taskManager.getTasks();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < tasks.size(); i++) {
                    sb.append(i + 1).append(". ").append(tasks.get(i).toString()).append("\n");
                }
                String message = sb.length() == 0 ? "No tasks yet." : sb.toString();
                JOptionPane.showMessageDialog(frame, message, " Task List ", JOptionPane.PLAIN_MESSAGE);;
            });

            // ---- Button 3: Mark Tasks as done ----
            // Creating instance of JButton
            JButton markDoneButton = new JButton(" Complete Task ");
            // adding button in JFrame
            frame.add(markDoneButton);
            // x axis, y axis, width, height
            markDoneButton.setBounds(140, 150, 220, 50);

            markDoneButton.addActionListener(e -> {
                String input = JOptionPane.showInputDialog(frame, "Task number to complete:", "Complete Task", JOptionPane.PLAIN_MESSAGE);
                if (input != null) {
                    try {
                        int index = Integer.parseInt(input.trim()) - 1; // convert to 0-based
                        if (taskManager.completeTask(index)) {
                            JOptionPane.showMessageDialog(frame, "Task Complete!", "Success", JOptionPane.PLAIN_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Invalid task number.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            // ---- Button 4: Delete Tasks ----
            // Creating instance of JButton
            JButton deleteButton = new JButton(" Delete Task ");
            // adding button in JFrame
            frame.add(deleteButton);
            // x axis, y axis, width, height
            deleteButton.setBounds(140, 200, 220, 50);

            deleteButton.addActionListener(e -> {
                String input = JOptionPane.showInputDialog(frame, "Task number to delete:", "Delete Task", JOptionPane.PLAIN_MESSAGE);
                if (input != null) {
                    try {
                        int index = Integer.parseInt(input.trim()) - 1; // convert to 0-based
                        if (taskManager.deleteTask(index)) {
                            JOptionPane.showMessageDialog(frame, "Task Deleted!", "Success", JOptionPane.PLAIN_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Invalid task number.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            // ---- Button 5: Exit ----
            JButton exitButton = new JButton("Exit");
            exitButton.setBounds(140, 250, 220, 50); // adjust y so it doesn't overlap your other buttons
            frame.add(exitButton);

            exitButton.addActionListener(e -> System.exit(0));

            // making the frame visible
            frame.setVisible(true);
        }
    }