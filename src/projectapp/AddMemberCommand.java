package projectapp;

import javax.swing.*;
import java.util.Objects;

public class AddMemberCommand implements Command {
    private DefaultListModel<String> teamListModel;

    public AddMemberCommand(DefaultListModel<String> teamListModel) {
        this.teamListModel = teamListModel;
    }

    @Override
    public void execute() {
        String memberName = JOptionPane.showInputDialog("Enter team member's name:");
        if (memberName != null && !memberName.trim().isEmpty()) {
            teamListModel.addElement(memberName);
        }
    }
}

