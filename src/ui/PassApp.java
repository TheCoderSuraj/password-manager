package src.ui;

import javax.swing.*;

import src.controller.DataController;
import src.func.encrypt.MyCipher;
import src.func.store.MasterKeyStore;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassApp extends JFrame {
    private JTextField masterKeyField;
    private JButton loginButton;

    public PassApp() {
        // initializing Cipher

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new FlowLayout());

        JLabel masterKeyLabel = new JLabel("Enter Master Key: ");
        masterKeyField = new JTextField(20);
        loginButton = new JButton("Login");
        JFrame frame = this;
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredMasterKey = masterKeyField.getText();
                if (enteredMasterKey.equals(MasterKeyStore.getMasterKey())) {
                    dispose();
                    DataController.init();
                    new HomeScreen();
                } else {
                    JOptionPane.showMessageDialog(frame, "Incorrect Master Key. Please try again.");
                }
            }
        });

        add(masterKeyLabel);
        add(masterKeyField);
        add(loginButton);

        setVisible(true);
    }

}
