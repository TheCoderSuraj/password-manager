package src.ui.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ButtonListExample {
    // public static void main(String[] args) {
    // List<String> stringList = List.of("Button 1", "Button 2", "Button 3", "Button
    // 4", "suraj");

    // SwingUtilities.invokeLater(() -> {
    // JFrame frame = new JFrame("Dynamic Buttons Example");
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setLayout(new FlowLayout());

    // for (String text : stringList) {
    // JButton button = new JButton(text);
    // button.addActionListener(new ActionListener() {
    // public void actionPerformed(ActionEvent e) {
    // JOptionPane.showMessageDialog(frame, "Button clicked: " + text);
    // }
    // });

    // frame.add(button);
    // }

    // frame.pack();
    // frame.setVisible(true);
    // });
    // }

    // public static void main(String[] args) {
    // List<String> stringList = List.of("Button 1", "Button 2", "Button 3", "Button
    // 4", "Button 5", "Button 6",
    // "Button 7", "Button 8", "Button 9");

    // SwingUtilities.invokeLater(() -> {
    // JFrame frame = new JFrame("Vertical Button Scroll Example");
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // JPanel buttonPanel = new JPanel();
    // buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

    // for (String text : stringList) {
    // JButton button = new JButton(text);
    // button.addActionListener(new ActionListener() {
    // public void actionPerformed(ActionEvent e) {
    // JOptionPane.showMessageDialog(frame, "Button clicked: " + text);
    // }
    // });

    // buttonPanel.add(button);
    // }

    // // Create a JScrollPane with the buttonPanel and set scrollbar policies
    // JScrollPane scrollPane = new JScrollPane(buttonPanel);
    // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    // scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    // // Add the scrollPane to the frame
    // frame.add(scrollPane);

    // // Pack the frame and set an initial size
    // frame.pack();
    // frame.setSize(300, 400);
    // frame.setVisible(true);
    // });
    // }

    public static void main(String[] args) {
        List<String> stringList = List.of("Button 1", "Button 2", "Button 3", "Button 4", "Button 5", "Button 6",
                "Button 7", "Button 8", "Button 9");

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Centered Button Scroll Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

            for (String text : stringList) {
                JButton button = new JButton(text);
                button.setAlignmentX(Component.CENTER_ALIGNMENT); // Center-align the button
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frame, "Button clicked: " + text);
                    }
                });

                buttonPanel.add(button);
            }

            // Create a JScrollPane with the buttonPanel and set scrollbar policies
            JScrollPane scrollPane = new JScrollPane(buttonPanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            // Add the scrollPane to the frame
            frame.add(scrollPane);

            // Pack the frame and set an initial size
            frame.pack();
            frame.setSize(300, 400);
            frame.setVisible(true);
        });
    }
}
