package projectapp;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private String description;
    private String Type;
    private List<Task> tasks;
    private List<TeamMember> members;

    public Project() {
        tasks = new ArrayList<>();
        members = new ArrayList<>();
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public Project(String name, String description, String Type) {
        this.name = name;
        this.description = description;
        this.Type = Type;

    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void addMember(TeamMember T) {
        members.add(T);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getType() {
        return Type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
