package src.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import src.controller.DataController;
import src.models.PasswordModel;
import src.utils.MyConstants;

public class PasswordsScreen extends JFrame {
    String website;

    PasswordsScreen(String url) {
        website = url;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(MyConstants.SCREEN_WIDTH, MyConstants.SCREEN_HEIGHT);
        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel websiteUrlLabel = new JLabel("Website URL: " + url);
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GetPassScreen();
            }

        });
        headerPanel.add(websiteUrlLabel, BorderLayout.CENTER);
        headerPanel.add(backButton, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(passwordPanel);

        Border entryBorder = BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK);

        for (PasswordModel password : DataController.getWebsiteData(url)) {

            JPanel entryPanel = createPasswordEntryPanel(password);
            entryPanel.setBorder(entryBorder);
            passwordPanel.add(entryPanel, BorderLayout.NORTH);
            System.out.println(password.getUsername());
        }
        setVisible(true);
    }

    private JPanel createPasswordEntryPanel(PasswordModel password) {
        JPanel entryPanel = new JPanel(new BorderLayout());
        entryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel labelPanel = new JPanel(new GridLayout(2, 1));
        JLabel usernameLabel = new JLabel("Username: " + password.getUsername());
        JLabel passwordLabel = new JLabel("PasswordModel: " + password.getPassword());
        labelPanel.add(usernameLabel);
        labelPanel.add(passwordLabel);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataController.deletePassword(password);
                dispose();
                ArrayList<PasswordModel> t = DataController.getWebsiteData(website);
                if (t.size() < 1) {
                    new GetPassScreen();
                } else {
                    new PasswordsScreen(website);
                }
            }

        });

        editButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                new EditPassScreen(password);
            }

        });

        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        entryPanel.add(labelPanel, BorderLayout.CENTER);
        entryPanel.add(buttonPanel, BorderLayout.EAST);
        entryPanel.setMaximumSize(new Dimension(MyConstants.SCREEN_WIDTH, MyConstants.PASSWORD_MAX_HEIGHT));
        ;

        return entryPanel;
    }

}
