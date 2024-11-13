package projectapp;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class ProjectFacade {

    
    private ShowProjects showProjects;
    private AddConsultant addConsultant;
    private Settings settings;
    private CreateProject createProject;
    public JPanel mainPanel;

    public ProjectFacade(JPanel mainPanel, CardLayout cardLayout) {
        // Initialize CreateProject with mainPanel and cardLayout
        this.createProject = new CreateProject(mainPanel, cardLayout);
        this.addConsultant = new AddConsultant(mainPanel, cardLayout);
        this.settings = new Settings();
        this.showProjects = new ShowProjects();
    }

    // Facade method to show project type options
    public void createNewProject() {
        createProject.showProjectTypeOptions();
    }

    // Facade method to display existing projects
    public void showProjects() {
        showProjects.display();
    }

    // Facade method to add a consultant
    public void addConsultant() {
        addConsultant.showConsultantTypeDialog();
    }

    // Facade method to open settings
    public void openSettings() {
        settings.configure();
    }
}
