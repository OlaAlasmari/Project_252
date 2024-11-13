package projectapp;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class AddConsultant {

    private JPanel mainPanel;
    private CardLayout cardLayout;
    private Project project = new Project();
    private ConsultantRegistry consultantRegistry = new ConsultantRegistry();
    private JTable consultantTable;
    private DefaultTableModel consultantTableModel;
    private JPanel parentComponent; // Parent component reference for dialogs

    public AddConsultant(JPanel parentPanel, CardLayout cardLayout) {
        this.mainPanel = parentPanel;
        this.cardLayout = cardLayout;
        initializeConsultantTable();
    }

    public void add() {
        System.out.println("Adding a consultant...");
        showConsultantTypeDialog(); // Show dialog to add consultant type when adding consultant
    }

    public void showConsultantTypeDialog() {
        String[] consultantTypes = {"Internal Consultant", "External Consultant"};
        String selectedConsultantType = (String) JOptionPane.showInputDialog(
                mainPanel, // Use mainPanel as the parent component for the dialog
                "Select Consultant Type",
                "Consultant Type",
                JOptionPane.QUESTION_MESSAGE,
                null,
                consultantTypes,
                consultantTypes[0]
        );

        if (selectedConsultantType != null) {
            showConsultantForm(selectedConsultantType.toLowerCase().replace(" ", ""));
            showConsultantScreen(); // Show the consultant screen directly after adding a consultant
        }
    }

    private void showConsultantForm(String consultantType) {
        JPanel formPanel = new JPanel(new GridLayout(4, 2));

        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(new JLabel("Phone number:"));
        formPanel.add(phoneField);

        int result = JOptionPane.showConfirmDialog(
                mainPanel, formPanel, "Enter Consultant Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String email = emailField.getText();
            String phoneNumber = phoneField.getText();

            // Pass consultantType as "InternalConsultant" or "ExternalConsultant" directly.
            addConsultant(consultantType.equals("internalconsultant") ? "InternalConsultant" : "ExternalConsultant",
                    name, email, phoneNumber);
        }
    }

    private void addConsultant(String consultantType, String name, String email, String phoneNumber) {
        Consultant consultant = consultantRegistry.createConsultant(consultantType); // Use Prototype pattern
        if (consultant != null) {
            //Prototype pattern
            consultant.addConsultantDetails(name, email, phoneNumber);
            consultantTableModel.addRow(new Object[]{name, email, phoneNumber, consultantType});
            JOptionPane.showMessageDialog(mainPanel, "Consultant added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            showConsultantScreen(); // Show consultant screen after adding
        } else {
            JOptionPane.showMessageDialog(mainPanel, "Error: Consultant type not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initializeConsultantTable() {
        consultantTableModel = new DefaultTableModel(new String[]{"Name", "Email", "Phone Number", "Type"}, 0);
        consultantTable = new JTable(consultantTableModel);
        consultantTable.setFont(new Font("Arial", Font.PLAIN, 14));
        consultantTable.setRowHeight(25);
        consultantTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        consultantTable.getTableHeader().setBackground(new Color(220, 200, 255));
    }

    private JPanel createConsultantPanel() {
        JPanel consultantPanel = new JPanel(new BorderLayout());
        consultantPanel.setBackground(new Color(245, 240, 255));

        JLabel titleLabel = new JLabel("Consultants");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(new Color(100, 50, 150));
        consultantPanel.add(titleLabel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(consultantTable);
        consultantPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.setBackground(new Color(200, 100, 100));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "homeScreen"));
        buttonPanel.add(backButton);

        consultantPanel.add(buttonPanel, BorderLayout.SOUTH);

        return consultantPanel;
    }

    private void showConsultantScreen() {
        if (mainPanel.getComponentCount() < 4) {
            JPanel consultantPanel = createConsultantPanel();
            mainPanel.add(consultantPanel, "consultantScreen");
        }
        cardLayout.show(mainPanel, "consultantScreen");
    }
}
