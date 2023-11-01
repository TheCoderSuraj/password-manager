package src.ui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import src.controller.DataController;
import src.utils.MyConstants;

public class GetPassScreen extends JFrame {
    GetPassScreen() {
        // JFrame getPasswordFrame = new JFrame("Get Password");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // setLayout(new FlowLayout());
        JButton back = new JButton("<-");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomeScreen();
            }

        });
        back.setBounds(10, 5, 80, 25);
        add(back);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        for (String text : DataController.getWebsites()) {
            JButton button = new JButton(text);
            button.setAlignmentX(CENTER_ALIGNMENT); // Center-align the button

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new PasswordsScreen(text);
                }
            });

            buttonPanel.add(button);
        }

        // Create a JScrollPane with the buttonPanel and set scrollbar policies
        JScrollPane scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add the scrollPane to the frame
        add(scrollPane);

        // Pack the frame and set an initial size
        pack();
        setSize(MyConstants.SCREEN_WIDTH, MyConstants.SCREEN_HEIGHT);
        setVisible(true);
    }
}
