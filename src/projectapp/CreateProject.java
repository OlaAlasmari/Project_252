package projectapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class CreateProject {

    private JPanel mainPanel;
    private CardLayout cardLayout;
    Project project = new Project();
    private DefaultListModel<String> teamListModel;

    public CreateProject(JPanel mainPanel, CardLayout cardLayout) {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;
        this.teamListModel = new DefaultListModel<>();
    }

    public void showProjectTypeOptions() {
        JPanel parentPanel = new JPanel(null);
        parentPanel.setBackground(new Color(245, 240, 255));

        JLabel titleLabel = new JLabel("Select type of the project");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(230, 90, 500, 50);

        parentPanel.add(titleLabel);

        JPanel projectOptionsPanel = new JPanel();
        projectOptionsPanel.setBounds(230, 150, 500, 300);
        projectOptionsPanel.setBackground(new Color(255, 255, 255, 180));
        projectOptionsPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.gridx = 0;
        gbc.gridy = 0;

        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Color buttonColor = new Color(230, 230, 250);

        JButton basicProjectButton = new JButton("Software Development Project");
        basicProjectButton.setFont(buttonFont);
        basicProjectButton.setBackground(buttonColor);
        basicProjectButton.setFocusPainted(false);
        basicProjectButton.setPreferredSize(new Dimension(230, 40));
        basicProjectButton.addActionListener(e -> showSoftwareDevelopment());
        projectOptionsPanel.add(basicProjectButton, gbc);

        gbc.gridy++;
        JButton teamProjectButton = new JButton("Marketing Campaign Project");
        teamProjectButton.setFont(buttonFont);
        teamProjectButton.setBackground(buttonColor);
        teamProjectButton.setFocusPainted(false);
        teamProjectButton.setPreferredSize(new Dimension(350, 40));
        teamProjectButton.addActionListener(e -> showMarketingCampaign());
        projectOptionsPanel.add(teamProjectButton, gbc);

        gbc.gridy++;
        JButton budgetProjectButton = new JButton("Research Project");
        budgetProjectButton.setFont(buttonFont);
        budgetProjectButton.setBackground(buttonColor);
        budgetProjectButton.setFocusPainted(false);
        budgetProjectButton.setPreferredSize(new Dimension(350, 40));
        budgetProjectButton.addActionListener(e -> showResearchProject());
        projectOptionsPanel.add(budgetProjectButton, gbc);

        gbc.gridy++;
        JButton back = new JButton("Back");
        back.setFont(buttonFont);
        back.setBackground(new Color(200, 100, 100));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setPreferredSize(new Dimension(350, 40));
        back.addActionListener(e -> cardLayout.show(mainPanel, "homeScreen"));
        projectOptionsPanel.add(back, gbc);

        parentPanel.add(projectOptionsPanel);
        mainPanel.add(parentPanel, "homeScreen");
        cardLayout.show(mainPanel, "homeScreen");
    }

    private void showSoftwareDevelopment() {
        JPanel taskPanel = createProjectPanel("Software Development Project",
                new String[]{"Task Name", "Description", "Subtasks", "Task Phase"},
                new String[]{"Planning", "Coding", "Testing", "Deploying"});
        mainPanel.add(taskPanel, "softwareDevelopment");
        cardLayout.show(mainPanel, "softwareDevelopment");
    }

    private void showMarketingCampaign() {
        JPanel teamProjectPanel = new JPanel(new BorderLayout());
        teamProjectPanel.setBackground(new Color(245, 240, 255));

        JLabel titleLabel = new JLabel("Marketing Campaign Project");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(new Color(100, 50, 150));
        teamProjectPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(245, 240, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        // Team Members Panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;

        JPanel teamPanel = new JPanel(new BorderLayout());
        teamPanel.setBackground(new Color(245, 240, 255));
        teamPanel.setBorder(BorderFactory.createTitledBorder("Team Members"));

        JList<String> teamList = new JList<>(teamListModel);
        JScrollPane teamScrollPane = new JScrollPane(teamList);
        teamPanel.add(teamScrollPane, BorderLayout.CENTER);

        JButton addMemberButton = createButton("Add Member", new Color(120, 100, 160), e -> {
            CommandInvoker commandInvoker = new CommandInvoker();
            commandInvoker.setCommand(new AddMemberCommand(teamListModel));
            commandInvoker.executeCommand();
        });
        teamPanel.add(addMemberButton, BorderLayout.SOUTH);
        contentPanel.add(teamPanel, gbc);

        // Tasks Panel
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        JPanel taskPanel = createTaskPanel("Marketing Campaign Project",
                new String[]{"Task Name", "Description", "Subtasks", "Task Type"},
                new String[]{"Content Creation", "Social Media Strategy", "Campaign Analytics"});
        contentPanel.add(taskPanel, gbc);

        teamProjectPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(teamProjectPanel, "marketingCampaign");
        cardLayout.show(mainPanel, "marketingCampaign");

    }

    private void showResearchProject() {
        JPanel researchProjectPanel = new JPanel(new BorderLayout());
        researchProjectPanel.setBackground(new Color(245, 240, 255));

        JLabel titleLabel = new JLabel("Research Project");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(new Color(100, 50, 150));
        researchProjectPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(245, 240, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        // Team Members Panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;

        JPanel teamPanel = new JPanel(new BorderLayout());
        teamPanel.setBackground(new Color(245, 240, 255));
        teamPanel.setBorder(BorderFactory.createTitledBorder("Team Members"));

        JList<String> teamList = new JList<>(teamListModel);
        JScrollPane teamScrollPane = new JScrollPane(teamList);
        teamPanel.add(teamScrollPane, BorderLayout.CENTER);

        JButton addMemberButton = createButton("Add Member", new Color(120, 100, 160), e -> {
            CommandInvoker commandInvoker = new CommandInvoker();
            commandInvoker.setCommand(new AddMemberCommand(teamListModel));
            commandInvoker.executeCommand();
        });
        teamPanel.add(addMemberButton, BorderLayout.SOUTH);
        contentPanel.add(teamPanel, gbc);

        // Tasks Panel
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        JPanel taskPanel = createTaskPanel("Research Project",
                new String[]{"Task Name", "Description", "Subtasks", "Task Type"},
                new String[]{"Data Collection", "Analysis", "Reporting"});
        contentPanel.add(taskPanel, gbc);

        researchProjectPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(researchProjectPanel, "researchProject");
        cardLayout.show(mainPanel, "researchProject");
    }

    // Utility method to create a project panel based on project type
    private JPanel createProjectPanel(String title, String[] columns, String[] taskTypes) {
        JPanel projectPanel = new JPanel(new BorderLayout());
        projectPanel.setBackground(new Color(245, 240, 255));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(new Color(100, 50, 150));
        projectPanel.add(titleLabel, BorderLayout.NORTH);

        // Task table
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable taskTable = new JTable(model);
        taskTable.setRowSelectionAllowed(true);
        taskTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taskTable.setFont(new Font("Arial", Font.PLAIN, 14));
        taskTable.setRowHeight(25);
        taskTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        taskTable.getTableHeader().setBackground(new Color(220, 200, 255));
        JScrollPane scrollPane = new JScrollPane(taskTable);
        projectPanel.add(scrollPane, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(245, 240, 255));

        JComboBox<String> taskTypeComboBox = new JComboBox<>(taskTypes);
        buttonPanel.add(taskTypeComboBox);

        JButton addTaskButton = createButton("Add Task", new Color(180, 160, 220), e -> {
            // Command pattern to add a task
            CommandInvoker commandInvoker = new CommandInvoker();
            String selectedTaskType = (String) taskTypeComboBox.getSelectedItem();
            commandInvoker.setCommand(new AddTaskCommand(model, project, selectedTaskType));
            commandInvoker.executeCommand();
        });

        JButton addSubtaskButton = createButton("Add Subtask", new Color(150, 130, 190), e -> {
            int selectedRow = taskTable.getSelectedRow();
            if (selectedRow != -1) {
                CommandInvoker commandInvoker = new CommandInvoker();
                commandInvoker.setCommand(new AddSubtaskCommand(model, taskTable, project));
                commandInvoker.executeCommand();
            } else {
                JOptionPane.showMessageDialog(null, "Please select a task to add a subtask.");
            }
        });

        JButton addMemberButton = createButton("Add Member", new Color(120, 100, 160), e -> {
            // Command to add a member (adjusted for team model)
            CommandInvoker commandInvoker = new CommandInvoker();
            commandInvoker.setCommand(new AddMemberCommand(new DefaultListModel<>()));
            commandInvoker.executeCommand();
        });

        JButton backButton = createButton("Back", new Color(200, 100, 100), e -> cardLayout.show(mainPanel, "projectOptions"));

        buttonPanel.add(addTaskButton);
        buttonPanel.add(addSubtaskButton);
        buttonPanel.add(backButton);
        projectPanel.add(buttonPanel, BorderLayout.SOUTH);

        return projectPanel;
    }

    // Utility method to create a button with specific properties
    private JButton createButton(String text, Color bgColor, ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(action);
        return button;
    }

    private JPanel createTaskPanel(String title, String[] columns, String[] taskTypes) {
        JPanel taskPanel = new JPanel(new BorderLayout());
        taskPanel.setBackground(new Color(245, 240, 255));
        taskPanel.setBorder(BorderFactory.createTitledBorder("Tasks"));

        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable taskTable = new JTable(model);
        taskTable.setRowSelectionAllowed(true);
        taskTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taskTable.setFont(new Font("Arial", Font.PLAIN, 14));
        taskTable.setRowHeight(25);
        taskTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        taskTable.getTableHeader().setBackground(new Color(220, 200, 255));
        JScrollPane scrollPane = new JScrollPane(taskTable);
        taskPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel taskButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        taskButtonPanel.setBackground(new Color(245, 240, 255));

        JComboBox<String> taskTypeComboBox = new JComboBox<>(taskTypes);
        taskButtonPanel.add(taskTypeComboBox);

        JButton addTaskButton = createButton("Add Task", new Color(120, 100, 160), e -> {
            CommandInvoker commandInvoker = new CommandInvoker();
            String selectedTaskType = (String) taskTypeComboBox.getSelectedItem();
            commandInvoker.setCommand(new AddTaskCommand(model, project, selectedTaskType));
            commandInvoker.executeCommand();
        });

        JButton addSubtaskButton = createButton("Add Subtask", new Color(150, 130, 190), e -> {
            int selectedRow = taskTable.getSelectedRow();
            if (selectedRow != -1) {
                CommandInvoker commandInvoker = new CommandInvoker();
                commandInvoker.setCommand(new AddSubtaskCommand(model, taskTable, project));
                commandInvoker.executeCommand();
            } else {
                JOptionPane.showMessageDialog(null, "Please select a task to add a subtask.");
            }
        });

        JButton backButton = createButton("Back", new Color(200, 100, 100), e -> cardLayout.show(mainPanel, "projectOptions"));

        taskButtonPanel.add(addTaskButton);
        taskButtonPanel.add(addSubtaskButton);
        taskButtonPanel.add(backButton);
        taskPanel.add(taskButtonPanel, BorderLayout.SOUTH);

        return taskPanel;
    }
}
