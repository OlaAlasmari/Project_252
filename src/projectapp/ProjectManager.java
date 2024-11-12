package projectapp;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager {

    private static List<Project> projects = new ArrayList<>();

    public List<Project> getProjects() {
        return projects;
    }

    public static void createProject(String projectType) {
        Project project;
        switch (projectType) {
            case "Basic Project":
                project = new Project("Basic Project", "A basic project with no additional features.");
                break;
            case "Team Project":
                project = new Project("Team Project", "A project that includes multiple team members.");
                break;
            case "Budget Project":
                project = new Project("Budget Project", "A project that includes budget management.");
                break;
            default:
                throw new IllegalArgumentException("Unknown project type");
        }
        projects.add(project);
        System.out.println("Project created: " + project.getName());
    }


}


