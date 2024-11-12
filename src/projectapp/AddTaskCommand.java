package projectapp;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AddTaskCommand implements Command {

    private DefaultTableModel tableModel;
    private Project project;
    private String task; //mean task type or phase

    public AddTaskCommand(DefaultTableModel tableModel, Project project, String task) {
        this.tableModel = tableModel;
        this.project = project;
        this.task = task;  
    }

    @Override
    public void execute() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        String taskDescription = JOptionPane.showInputDialog("Enter Task Description:");
        if (taskName != null && taskDescription != null && !taskName.isEmpty()) {
            // Pass the selected task phase to the new Task object
            Task newTask = new Task(taskName, taskDescription, task, "2024-11-30");
            project.addTask(newTask); 
            System.out.println("Task added to Project: " + newTask.getName());
            System.out.println("Current tasks in project: " + project.getTasks().size());

            // Add task to the table model, including the task type
            tableModel.addRow(new Object[]{taskName, taskDescription, "", task});
        }
    }
}

