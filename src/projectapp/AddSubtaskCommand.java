package projectapp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddSubtaskCommand implements Command {

    private DefaultTableModel tableModel;
    private JTable taskTable;
    private Project project;

    public AddSubtaskCommand(DefaultTableModel tableModel, JTable taskTable, Project project) {
        this.tableModel = tableModel;
        this.taskTable = taskTable;
        this.project = project;
    }

    @Override
    public void execute() {
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a task to add a subtask.");
            return;
        }

        // Retrieve the task based on selected row
        Task selectedTask = project.getTasks().size() > selectedRow ? project.getTasks().get(selectedRow) : null;

        if (selectedTask == null) {
            System.out.println("Error: Selected task is null, unable to retrieve task at row " + selectedRow);
            JOptionPane.showMessageDialog(null, "Error: Task not found. Please add a task first.");
            return;
        }

        // Prompt for subtask name
        String subtaskName = JOptionPane.showInputDialog("Enter Subtask Name:");
        if (subtaskName != null && !subtaskName.isEmpty()) {
            selectedTask.addSubtask(subtaskName);  // Add subtask to the selected task
            System.out.println("Subtask added to task: " + subtaskName);

            // Update the "Subtasks" column in the table model
            String existingSubtasks = (String) tableModel.getValueAt(selectedRow, 2);
            if (existingSubtasks == null) {
                existingSubtasks = "";
            }
            tableModel.setValueAt(existingSubtasks + "\n- " + subtaskName, selectedRow, 2);
            tableModel.fireTableDataChanged();
        }
    }
}
