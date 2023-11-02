package src.ui.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordManagerApp {
    private static final String MASTER_KEY = "Suraj@123"; // Replace with your desired master key

    private JFrame mainFrame;
    private JTextField masterKeyField;
    private JButton loginButton;

    public PasswordManagerApp() {
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
        mainFrame.dispose(); // Close the login page

        // Create the next page (add or get password options)
        JFrame nextPageFrame = new JFrame("Password Manager - Options");
        nextPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nextPageFrame.setSize(300, 150);
        nextPageFrame.setLayout(new FlowLayout());

        JButton addPasswordButton = new JButton("Add Password");
        JButton getPasswordButton = new JButton("Get Password");

        addPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add password functionality goes here
                JOptionPane.showMessageDialog(nextPageFrame, "You clicked 'Add Password'");
            }
        });

        getPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get password functionality goes here
                JOptionPane.showMessageDialog(nextPageFrame, "You clicked 'Get Password'");
            }
        });

        nextPageFrame.add(addPasswordButton);
        nextPageFrame.add(getPasswordButton);

        nextPageFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestPass();
            }
        });
    }
}
