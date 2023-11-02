package src.ui.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Custom extends JPanel {
    private DefaultListModel<String> listModel;
    private JList<String> itemList;
    private JTextField newItemTextField;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;

    public Custom() {
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(itemList);
        add(scrollPane, BorderLayout.CENTER);

        newItemTextField = new JTextField(20);
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(newItemTextField);
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newItem = newItemTextField.getText();
                if (!newItem.isEmpty()) {
                    listModel.addElement(newItem);
                    newItemTextField.setText("");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = itemList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    listModel.remove(selectedIndex);
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = itemList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    String updatedItem = newItemTextField.getText();
                    if (!updatedItem.isEmpty()) {
                        listModel.setElementAt(updatedItem, selectedIndex);
                        newItemTextField.setText("");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom List Builder");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new Custom());
            frame.pack();
            frame.setVisible(true);
        });
    }
}
