package src.ui.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PassApp {
    private static final String MASTER_KEY = "Suraj@123";
    private Map<String, Map<String, String>> passwords = new HashMap<>();

    private JFrame mainFrame;
    private JTextField masterKeyField;
    private JButton loginButton;

    public PassApp() {
        mainFrame = new JFrame("Password Manager App");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(300, 150);
        mainFrame.setLayout(new FlowLayout());

        JLabel masterKeyLabel = new JLabel("Enter Master Key: ");
        masterKeyField = new JTextField(20);
        loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredMasterKey = masterKeyField.getText();
                if (enteredMasterKey.equals(MASTER_KEY)) {
                    openNextPage();
                } else {
                    JOptionPane.showMessageDialog(mainFrame, "Incorrect Master Key. Please try again.");
                }
            }
        });

        mainFrame.add(masterKeyLabel);
        mainFrame.add(masterKeyField);
        mainFrame.add(loginButton);

        mainFrame.setVisible(true);
    }

    private void openNextPage() {
        mainFrame.dispose();

        JFrame nextPageFrame = new JFrame("Password Manager - Options");
        nextPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nextPageFrame.setSize(300, 150);
        nextPageFrame.setLayout(new FlowLayout());

        JButton addPasswordButton = new JButton("Add Password");
        JButton getPasswordButton = new JButton("Get Password");

        // ... (same as before)

        addPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAddPasswordPage();
            }
        });

        getPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGetPasswordPage();
            }
        });

        nextPageFrame.add(addPasswordButton);
        nextPageFrame.add(getPasswordButton);

        nextPageFrame.setVisible(true);
    }

    private void openAddPasswordPage() {
        JFrame addPasswordFrame = new JFrame("Add Password");
        addPasswordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addPasswordFrame.setSize(300, 200);
        addPasswordFrame.setLayout(new FlowLayout());

        JLabel urlLabel = new JLabel("Website URL: ");
        JTextField urlField = new JTextField(20);
        JLabel usernameLabel = new JLabel("Username: ");
        JTextField usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField(20);
        JButton saveButton = new JButton("Save");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = urlField.getText();
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                // Store the password information in the 'passwords' map
                Map<String, String> credentials = new HashMap<>();
                credentials.put("username", username);
                credentials.put("password", new String(password));
                passwords.put(url, credentials);

                // Clear the password field
                passwordField.setText("");

                JOptionPane.showMessageDialog(addPasswordFrame, "Password saved successfully.");
                // nextPageFrame.setVisible(true);
            }
        });

        addPasswordFrame.add(urlLabel);
        addPasswordFrame.add(urlField);
        addPasswordFrame.add(usernameLabel);
        addPasswordFrame.add(usernameField);
        addPasswordFrame.add(passwordLabel);
        addPasswordFrame.add(passwordField);
        addPasswordFrame.add(saveButton);

        addPasswordFrame.setVisible(true);
    }

    private void openGetPasswordPage() {
        JFrame getPasswordFrame = new JFrame("Get Password");
        getPasswordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getPasswordFrame.setSize(400, 200);
        getPasswordFrame.setLayout(new FlowLayout());

        DefaultListModel<String> urlListModel = new DefaultListModel<>();
        JList<String> urlList = new JList<>(urlListModel);
        JScrollPane urlScrollPane = new JScrollPane(urlList);

        JButton getPasswordButton = new JButton("Get Password");
        JTextField usernameDisplayField = new JTextField(20);
        JTextField passwordDisplayField = new JTextField(20);
        passwordDisplayField.setEditable(false);

        // Populate the list of saved URLs
        urlListModel.addAll(passwords.keySet());

        getPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedUrl = urlList.getSelectedValue();
                if (selectedUrl != null) {
                    Map<String, String> credentials = passwords.get(selectedUrl);
                    if (credentials != null) {
                        usernameDisplayField.setText(credentials.get("username"));
                        passwordDisplayField.setText(credentials.get("password"));
                    }
                }
            }
        });

        getPasswordFrame.add(urlScrollPane);
        getPasswordFrame.add(getPasswordButton);
        getPasswordFrame.add(usernameDisplayField);
        getPasswordFrame.add(passwordDisplayField);

        getPasswordFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PassApp();
            }
        });
    }
}
