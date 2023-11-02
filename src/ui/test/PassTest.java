package src.ui.test;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PassTest extends JPanel {

    private List<Password> passwordList;

    public PassTest(List<Password> passwords) {
        this.passwordList = passwords;

        // Create the main panel
        setLayout(new BorderLayout());

        // Create the scroll pane
        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);

        // Create the password panel
        JPanel passwordPanel = new JPanel(new GridLayout(passwordList.size(), 1));
        scrollPane.setViewportView(passwordPanel);

        Border entryBorder = BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK);

        // Add the passwords to the password panel
        for (Password password : passwordList) {
            JPanel entryPanel = createPasswordEntryPanel(password);
            entryPanel.setBorder(entryBorder);
            passwordPanel.add(entryPanel, BorderLayout.NORTH);
        }
    }

    private JPanel createPasswordEntryPanel(Password password) {
        // JPanel entryPanel = new JPanel(new BorderLayout());
        // entryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // JPanel labelPanel = new JPanel(new GridLayout(2, 1));
        // JLabel usernameLabel = new JLabel("Username: " + password.getUsername());
        // JLabel passwordLabel = new JLabel("Password: " + password.getPassword());
        // labelPanel.add(usernameLabel);
        // labelPanel.add(passwordLabel);

        // JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        // JButton editButton = new JButton("Edit");
        // JButton deleteButton = new JButton("Delete");
        // buttonPanel.add(editButton);
        // buttonPanel.add(deleteButton);

        // entryPanel.add(labelPanel, BorderLayout.CENTER);
        // entryPanel.add(buttonPanel, BorderLayout.EAST);

        // return entryPanel;
        JPanel entryPanel = new JPanel(new BorderLayout());
        entryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel labelPanel = new JPanel(new GridLayout(2, 1));
        JLabel usernameLabel = new JLabel("Username: " + password.getUsername());
        JLabel passwordLabel = new JLabel("Password: " + password.getPassword());
        labelPanel.add(usernameLabel);
        labelPanel.add(passwordLabel);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        entryPanel.add(labelPanel, BorderLayout.CENTER);
        entryPanel.add(buttonPanel, BorderLayout.EAST);
        return entryPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            List<Password> passwordList = new ArrayList<>();
            passwordList.add(new Password("username1", "password1"));
            passwordList.add(new Password("username2", "password2"));
            // Add more passwords as needed

            JFrame frame = new JFrame("Password Manager");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PassTest passwordManager = new PassTest(passwordList);
            frame.add(passwordManager);
            frame.pack();
            frame.setVisible(true);
        });
    }
}

class Password {
    private String username;
    private String password;

    public Password(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}