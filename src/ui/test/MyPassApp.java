// package src.ui.test;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.io.*;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.Scanner;

// public class MyPassApp {
// private static final String MASTER_KEY = "Suraj@123";
// private Map<String, Map<String, String>> passwords = new HashMap<>();

// private JFrame mainFrame;
// private JFrame mainOptionsFrame;

// public MyPassApp() {
// mainFrame = new JFrame("Password Manager App");
// mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// mainFrame.setSize(300, 150);
// mainFrame.setLayout(new FlowLayout());

// // ... (same as before)

// mainFrame.setVisible(true);
// }

// private void openNextPage() {
// mainFrame.dispose();

// mainOptionsFrame = new JFrame("Password Manager - Options");
// mainOptionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// mainOptionsFrame.setSize(300, 150);
// mainOptionsFrame.setLayout(new FlowLayout());

// JButton addPasswordButton = new JButton("Add Password");
// JButton getPasswordButton = new JButton("Get Password");

// // ... (same as before)

// addPasswordButton.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// openAddPasswordPage();
// }
// });

// getPasswordButton.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// openGetPasswordPage();
// }
// });

// mainOptionsFrame.add(addPasswordButton);
// mainOptionsFrame.add(getPasswordButton);

// mainOptionsFrame.setVisible(true);
// }

// private void openAddPasswordPage() {
// JFrame addPasswordFrame = new JFrame("Add Password");
// addPasswordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
// addPasswordFrame.setSize(300, 200);
// addPasswordFrame.setLayout(new FlowLayout());

// // ... (URL, username, password fields)

// JButton saveButton = new JButton("Save");
// JButton goBackButton = new JButton("Go Back");

// saveButton.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// // ... (saving password)

// // Save the password to a file
// // try {
// // BufferedWriter writer = new BufferedWriter(new FileWriter("passwords.txt",
// // true));
// // writer.write(url + "," + username + "," + new String(password));
// // writer.newLine();
// // writer.close();
// // } catch (IOException ioException) {
// // ioException.printStackTrace();
// // }

// JOptionPane.showMessageDialog(addPasswordFrame, "Password saved
// successfully.");

// addPasswordFrame.dispose();
// mainOptionsFrame.setVisible(true);
// }
// });

// goBackButton.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// addPasswordFrame.dispose();
// mainOptionsFrame.setVisible(true);
// }
// });

// // addPasswordFrame.add(urlLabel);
// // addPasswordFrame.add(urlField);
// // addPasswordFrame.add(usernameLabel);
// // addPasswordFrame.add(usernameField);
// // addPasswordFrame.add(passwordLabel);
// // addPasswordFrame.add(passwordField);
// // addPasswordFrame.add(saveButton);
// // addPasswordFrame.add(goBackButton);

// addPasswordFrame.setVisible(true);
// }

// private void openGetPasswordPage() {
// JFrame getPasswordFrame = new JFrame("Get Password");
// getPasswordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
// getPasswordFrame.setSize(400, 200);
// getPasswordFrame.setLayout(new FlowLayout());

// DefaultListModel<String> urlListModel = new DefaultListModel<>();
// JList<String> urlList = new JList<>(urlListModel);
// JScrollPane urlScrollPane = new JScrollPane(urlList);

// JButton getPasswordButton = new JButton("Get Password");
// JTextField usernameDisplayField = new JTextField(20);
// JTextField passwordDisplayField = new JTextField(20);
// passwordDisplayField.setEditable(false);

// // Read passwords from the file
// try {
// Scanner scanner = new Scanner(new File("passwords.txt"));
// while (scanner.hasNextLine()) {
// String line = scanner.nextLine();
// String[] parts = line.split(",");
// if (parts.length == 3) {
// String url = parts[0];
// String username = parts[1];
// String password = parts[2];

// Map<String, String> credentials = new HashMap<>();
// credentials.put("username", username);
// credentials.put("password", password);
// passwords.put(url, credentials);
// urlListModel.addElement(url);
// }
// }
// scanner.close();
// } catch (IOException ioException) {
// ioException.printStackTrace();
// }

// getPasswordButton.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// String selectedUrl = urlList.getSelectedValue();
// if (selectedUrl != null) {
// Map<String, String> credentials = passwords.get(selectedUrl);
// if (credentials != null) {
// usernameDisplayField.setText(credentials.get("username"));
// passwordDisplayField.setText(credentials.get("password"));
// }
// }
// }
// });

// getPasswordFrame.add(urlScrollPane);
// getPasswordFrame.add(getPasswordButton);
// getPasswordFrame.add(usernameDisplayField);
// getPasswordFrame.add(passwordDisplayField);

// getPasswordFrame.setVisible(true);
// }

// public static void main(String[] args) {
// SwingUtilities.invokeLater(new Runnable() {
// @Override
// public void run() {
// new MyPassApp();
// }
// });
// }
// }
