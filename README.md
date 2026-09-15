# Final-Year Dashboard

A desktop task manager built with Java and Swing. Add, view, complete, and delete tasks through a simple GUI, with tasks saved to disk so they persist between sessions.

Built as a hands-on introduction to GUI development and event-driven programming in Java.

## Features

- Add tasks with a description
- View all tasks, numbered, showing pending/complete status
- Mark tasks as complete
- Delete tasks
- Tasks persist between runs (saved locally)

## Built with

- Java
- Swing (GUI)
- IntelliJ IDEA

## How to run

1. Clone the repo
2. Open the project in IntelliJ IDEA
3. Run `TaskManagerGUI.java`

## What I learned

- Structuring a small app into model (`Task`), logic (`TaskManager`), and GUI (`TaskManagerGUI`) layers
- Handling Swing events with `ActionListener`
- Reading/writing files for basic persistence
- Debugging real issues beyond syntax errors — e.g. tracking down a silent image-loading failure caused by a CMYK-profile JPEG that Java's `ImageIO` couldn't parse

## Possible future improvements

- Replace `setLayout(null)` with a proper layout manager
- Move to a real database instead of a text file
- Add input validation and better error handling