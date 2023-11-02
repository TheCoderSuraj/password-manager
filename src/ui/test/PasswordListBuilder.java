// package src.ui.test;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.ArrayList;
// import java.util.List;

// public class PasswordListBuilder {
// private JFrame frame;
// private JList<PasswordModel> passwordList;
// private DefaultListModel<PasswordModel> listModel;
// private JButton goBackButton;
// private JButton deleteButton;
// private JButton updateButton;

// private List<PasswordModel> data;

// public PasswordListBuilder() {
// frame = new JFrame("Password List Builder");
// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// frame.setLayout(new BorderLayout());

// listModel = new DefaultListModel<>();
// passwordList = new JList<>(listModel);
// JScrollPane scrollPane = new JScrollPane(passwordList);
// frame.add(scrollPane, BorderLayout.CENTER);

// goBackButton = new JButton("Go Back");
// deleteButton = new JButton("Delete");
// updateButton = new JButton("Update");

// JPanel buttonPanel = new JPanel();
// buttonPanel.add(goBackButton);
// buttonPanel.add(deleteButton);
// buttonPanel.add(updateButton);
// frame.add(buttonPanel, BorderLayout.SOUTH);

// // Initialize your data (e.g., from a list of PasswordModel objects)
// data = new ArrayList<>();
// data.add(new PasswordModel("Website 1", "Password 1", "User 1"));
// data.add(new PasswordModel("Website 2", "Password 2", "User 2"));
// data.add(new PasswordModel("Website 3", "Password 3", "User 3"));
// data.add(new PasswordModel("Website 2", "Password 2", "User 2"));
// data.add(new PasswordModel("Website 3", "Password 3", "User 3"));
// data.add(new PasswordModel("Website 2", "Password 2", "User 2"));
// data.add(new PasswordModel("Website 3", "Password 3", "User 3"));
// data.add(new PasswordModel("Website 2", "Password 2", "User 2"));
// data.add(new PasswordModel("Website 3", "Password 3", "User 3"));
// data.add(new PasswordModel("Website 2", "Password 2", "User 2"));
// data.add(new PasswordModel("Website 3", "Password 3", "User 3"));

// // Populate the JList with your data
// for (PasswordModel model : data) {
// listModel.addElement(model);
// }

// // Add action listeners for the buttons
// goBackButton.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// // Handle the "Go Back" button click
// }
// });

// deleteButton.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// // Handle the "Delete" button click
// int selectedIndex = passwordList.getSelectedIndex();
// if (selectedIndex >= 0) {
// listModel.remove(selectedIndex);
// }
// }
// });

// updateButton.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// // Handle the "Update" button click
// int selectedIndex = passwordList.getSelectedIndex();
// if (selectedIndex >= 0) {
// PasswordModel selectedModel = listModel.getElementAt(selectedIndex);
// // Perform the update operation for the selected element
// // You can display a dialog or open another window for updating the element
// }
// }
// });

// frame.pack();
// frame.setVisible(true);
// }

// public static void main(String[] args) {
// SwingUtilities.invokeLater(() -> new PasswordListBuilder());
// }
// }

// // class PasswordModel {
// // private String website;
// // private String password;
// // private String username;

// // public PasswordModel(String website, String password, String username) {
// // this.website = website;
// // this.password = password;
// // this.username = username;
// // }

// // // Getters and setters for the fields
// // }
