package projectapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;


public class ProjectApp extends JFrame {

    private ProjectFacade projectFacade;
    public JPanel mainPanel;
    public CardLayout cardLayout;
    private CreateProject createProject;

    public ProjectApp() {
        // Initialize cardLayout and mainPanel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Initialize ProjectFacade with mainPanel and cardLayout
        projectFacade = new ProjectFacade(mainPanel, cardLayout);

        setTitle("Project Management App");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel homePanel = createHomePanel();

        mainPanel.add(homePanel, "homeScreen");

        add(mainPanel);

    }

    private JPanel createHomePanel() {
        ImageIcon backgroundIcon = new ImageIcon("Background.png");
        Image backgroundImage = backgroundIcon.getImage();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        panel.setLayout(null);

        JLabel projectLabel = new JLabel("Project");
        projectLabel.setFont(new Font("Arial", Font.BOLD, 58));
        projectLabel.setForeground(Color.BLACK);
        projectLabel.setBounds(400, 150, 300, 60);
        panel.add(projectLabel);

        JLabel managementLabel = new JLabel("Management App");
        managementLabel.setFont(new Font("Arial", Font.BOLD, 58));
        managementLabel.setForeground(Color.BLACK);
        managementLabel.setBounds(250, 240, 550, 80);
        panel.add(managementLabel);

        JButton loginButton = new JButton("LOG IN");
        loginButton.setBounds(310, 370, 150, 40);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(new Color(230, 230, 250));
        loginButton.setForeground(Color.BLACK);
        loginButton.addActionListener(e -> showLoginScreen());
        panel.add(loginButton);

        JButton signupButton = new JButton("SIGN UP");
        signupButton.setBounds(500, 370, 150, 40);
        signupButton.setFont(new Font("Arial", Font.BOLD, 16));
        signupButton.setBackground(new Color(230, 230, 250));
        signupButton.setForeground(Color.BLACK);
        signupButton.addActionListener(e -> showSignupScreen());
        panel.add(signupButton);

        return panel;
    }

    private void showLoginScreen() {
        if (mainPanel.getComponentCount() < 2) {
            JPanel loginPanel = createLoginScreen();
            mainPanel.add(loginPanel, "loginScreen");
        }
        cardLayout.show(mainPanel, "loginScreen");
    }

    public JPanel createLoginScreen() {
        JPanel loginPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundIcon = new ImageIcon("Background.png");
                g.drawImage(backgroundIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        loginPanel.setLayout(null);

        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(new Color(255, 255, 255, 150));
        whitePanel.setBounds(300, 150, 400, 250);
        whitePanel.setLayout(null);
        whitePanel.setOpaque(true);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        emailLabel.setBounds(50, 50, 100, 25);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 50, 200, 25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        passwordLabel.setBounds(50, 100, 100, 25);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 25);

        JButton loginBtn = new JButton("LOG IN");
        loginBtn.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        loginBtn.setBackground(new Color(230, 230, 250));
        loginBtn.setBounds(150, 180, 100, 30);
        loginBtn.addActionListener(e -> showHomeScreen());
        loginPanel.add(loginBtn);

        whitePanel.add(emailLabel);
        whitePanel.add(emailField);
        whitePanel.add(passwordLabel);
        whitePanel.add(passwordField);
        whitePanel.add(loginBtn);

        loginPanel.add(whitePanel);

        return loginPanel;
    }

    private void showSignupScreen() {
        if (mainPanel.getComponentCount() < 3) {
            JPanel signupPanel = createSignupScreen();
            mainPanel.add(signupPanel, "signupScreen");
        }
        cardLayout.show(mainPanel, "signupScreen");
    }

    public JPanel createSignupScreen() {
        JPanel signupPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundIcon = new ImageIcon("Background.png");
                g.drawImage(backgroundIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        signupPanel.setLayout(null);

        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(new Color(255, 255, 255, 150));
        whitePanel.setBounds(300, 100, 400, 350);
        whitePanel.setLayout(null);
        whitePanel.setOpaque(true);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        nameLabel.setBounds(50, 50, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 50, 200, 25);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        phoneLabel.setBounds(50, 100, 100, 25);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(150, 100, 200, 25);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        emailLabel.setBounds(50, 150, 100, 25);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 150, 200, 25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        passwordLabel.setBounds(50, 200, 100, 25);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 200, 200, 25);

        JButton signupBtn = new JButton("SIGN UP");
        signupBtn.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        signupBtn.setBackground(new Color(230, 230, 250));
        signupBtn.setBounds(150, 280, 100, 30);
        signupBtn.addActionListener(e -> showHomeScreen());
        signupPanel.add(signupBtn);

        whitePanel.add(nameLabel);
        whitePanel.add(nameField);
        whitePanel.add(phoneLabel);
        whitePanel.add(phoneField);
        whitePanel.add(emailLabel);
        whitePanel.add(emailField);
        whitePanel.add(passwordLabel);
        whitePanel.add(passwordField);
        whitePanel.add(signupBtn);

        signupPanel.add(whitePanel);

        return signupPanel;
    }

    private void showHomeScreen() {
        if (mainPanel.getComponentCount() < 3) {
            JPanel homeImagePanel = createHomeImagePanel();
            mainPanel.add(homeImagePanel, "homeImageScreen");
        }
        cardLayout.show(mainPanel, "homeImageScreen");
    }

    private JPanel createHomeImagePanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon homeIcon = new ImageIcon("background2.png");
                Image homeImage = homeIcon.getImage();

                if (homeImage != null) {
                    g.drawImage(homeImage, 0, 0, getWidth(), getHeight(), this);
                } else {
                    System.out.println("Error: Home image not found or failed to load.");
                }
            }
        };
        panel.setLayout(null);

        // Create new project
        JButton createProjectButton = new JButton("");
        createProjectButton.setBounds(50, 220, 150, 40);
        createProjectButton.setFocusPainted(false);
        createProjectButton.setContentAreaFilled(false);
        createProjectButton.setOpaque(false);
        createProjectButton.setBorderPainted(false);

        createProjectButton.addActionListener(e -> projectFacade.createNewProject());

        // Add button to the panel
        panel.add(createProjectButton, BorderLayout.CENTER);

        // "Show projects"
        JButton showProjectsButton = new JButton("");
        showProjectsButton.setBounds(50, 290, 150, 40);
        showProjectsButton.setFocusPainted(false);
        showProjectsButton.setContentAreaFilled(false);
        showProjectsButton.setOpaque(false);
        showProjectsButton.setBorderPainted(false);
        showProjectsButton.addActionListener(e -> projectFacade.showProjects());
        panel.add(showProjectsButton);

        // "Add Consultant"
        JButton addConsultantButton = new JButton("");
        addConsultantButton.setBounds(50, 360, 150, 40);
        addConsultantButton.setFocusPainted(false);
        addConsultantButton.setContentAreaFilled(false);
        addConsultantButton.setOpaque(false);
        addConsultantButton.setBorderPainted(false);
        addConsultantButton.addActionListener(e -> projectFacade.addConsultant());
        panel.add(addConsultantButton);

        // "Settings"
        JButton settingsButton = new JButton("");
        settingsButton.setBounds(50, 430, 150, 40);
        settingsButton.setFocusPainted(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setOpaque(false);
        settingsButton.setBorderPainted(false);
        settingsButton.addActionListener(e -> projectFacade.openSettings());
        panel.add(settingsButton);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProjectApp app = new ProjectApp();
            app.setVisible(true);
        });
    }
}
