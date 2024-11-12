package projectapp;

import java.util.ArrayList;
import java.util.List;

public class Task {

    private String name;
    private String description;
    private String type;
    private TeamMember assignedMember;
    private String status;
    private String deadline;
    private List<String> subtasks;  
    public Task(String name, String description, String type, String deadline) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.deadline = deadline;
        this.subtasks = new ArrayList<>();  
    }

    public void addSubtask(String subtask) {
        subtasks.add(subtask);  
    }

    public List<String> getSubtasks() {
        return subtasks;
    }

    public void setAssignedMember(TeamMember assignedMember) {
        this.assignedMember = assignedMember;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
    
    public String getDescription() {
        return description;
    }


}
