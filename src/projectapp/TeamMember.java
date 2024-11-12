package projectapp;

import java.util.List;

public class TeamMember {

    private String name;
    private String role;
    private String email;
    

    public TeamMember(String email) {
        this.email = email;
    }

    public TeamMember(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }
}
