package src.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import src.controller.DataController;
import src.func.encrypt.CipherNotInitException;
import src.models.PasswordModel;
import src.utils.MyConstants;

public class EditPassScreen extends JFrame {
    PasswordModel pass;

    EditPassScreen(PasswordModel model) {
        this.pass = model;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(MyConstants.SCREEN_WIDTH, MyConstants.SCREEN_HEIGHT);
        setLayout(new FlowLayout());

        JLabel urlLabel = new JLabel("Website URL: ");
        JTextField urlField = new JTextField(20);
        JLabel usernameLabel = new JLabel("Username: ");
        JTextField usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField(20);
        JButton updateButton = new JButton("Update");
        JButton goBackButton = new JButton("Go Back");

        urlField.setText(pass.getWebsite());
        usernameField.setText(pass.getUsername());
        passwordField.setText(pass.getPassword());
        urlField.setEditable(false);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                Map<String, String> credentials = new HashMap<>();
                credentials.put("username", username);
                credentials.put("password", new String(password));
                // passwords.put(url, credentials);
                try {
                    DataController.updatePassword(pass,
                            new PasswordModel(pass.getWebsite(), username, password.toString()));
                    dispose();
                    new GetPassScreen();
                    JOptionPane.showMessageDialog(null, "Password saved successfully.");

                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.err.println("we got error on storing password");
                }

                urlField.setText("");
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PasswordsScreen(pass.getWebsite());
            }
        });

        add(urlLabel);
        add(urlField);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(updateButton);
        add(goBackButton);

        setVisible(true);

    }

}
