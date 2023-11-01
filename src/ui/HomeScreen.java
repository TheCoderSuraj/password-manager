package src.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import src.utils.MyConstants;

public class HomeScreen extends JFrame {
    HomeScreen() {
        // JFrame nextPageFrame = new JFrame("Password Manager - Options");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(MyConstants.SCREEN_WIDTH, MyConstants.SCREEN_HEIGHT);
        // setLayout(new ());
        setLayout(null);

        JButton addPasswordButton = new JButton("Add Password");
        JButton getPasswordButton = new JButton("Get Password");
        addPasswordButton.setBounds((MyConstants.SCREEN_WIDTH - 150) / 2, 40, 150, 25);
        getPasswordButton.setBounds((MyConstants.SCREEN_WIDTH - 150) / 2, 70, 150, 25);

        addPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // openAddPasswordPage();
                dispose();
                new AddPassScreen();
            }
        });

        getPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // openGetPasswordPage();
                dispose();
                new GetPassScreen();
            }
        });

        add(addPasswordButton);
        add(getPasswordButton);

        setVisible(true);

    }

}
