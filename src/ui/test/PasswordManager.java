package src.ui.test;

// import javax.swing.*;
// import javax.swing.border.EmptyBorder;

// import src.models.PasswordModel;

// import java.awt.*;
// import java.util.ArrayList;
// import java.util.List;

// public class PasswordManager extends JPanel {

//     private List<PasswordModel> passwordList;

//     public PasswordManager() {
//         // Create the password list
//         passwordList = new ArrayList<>();
//         passwordList.add(new PasswordModel("Website 1", "username1", "password1"));
//         passwordList.add(new PasswordModel("Website 2", "username2", "password2"));
//         // Add more passwords as needed

//         // Create the main panel
//         setLayout(new BorderLayout());

//         // Create the scroll pane
//         JScrollPane scrollPane = new JScrollPane();
//         add(scrollPane, BorderLayout.CENTER);

//         // Create the password panel
//         JPanel passwordPanel = new JPanel();
//         passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.Y_AXIS));
//         scrollPane.setViewportView(passwordPanel);

//         // Add the passwords to the password panel
//         for (PasswordModel password : passwordList) {
//             JPanel entryPanel = createPasswordEntryPanel(password);
//             passwordPanel.add(entryPanel);
//         }
//     }

//     private JPanel createPasswordEntryPanel(PasswordModel password) {
//         JPanel entryPanel = new JPanel(new BorderLayout());
//         entryPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

//         JLabel websiteLabel = new JLabel(password.website);
//         JLabel usernameLabel = new JLabel("Username: " + password.username);
//         JLabel passwordLabel = new JLabel("PasswordModel: " + password.password);

//         JButton editButton = new JButton("Edit");
//         JButton deleteButton = new JButton("Delete");

//         JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//         buttonPanel.add(editButton);
//         buttonPanel.add(deleteButton);

//         entryPanel.add(websiteLabel, BorderLayout.NORTH);
//         entryPanel.add(usernameLabel, BorderLayout.CENTER);
//         entryPanel.add(passwordLabel, BorderLayout.SOUTH);
//         entryPanel.add(buttonPanel, BorderLayout.EAST);

//         return entryPanel;
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             JFrame frame = new JFrame("PasswordModel Manager");
//             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//             PasswordManager passwordManager = new PasswordManager();
//             frame.add(passwordManager);
//             frame.pack();
//             frame.setVisible(true);
//         });
//     }
// }

// import javax.swing.*;
// import javax.swing.border.EmptyBorder;

// import src.models.PasswordModel;

// import java.awt.*;
// import java.util.ArrayList;
// import java.util.List;

// public class PasswordManager extends JPanel {

//     private List<PasswordModel> passwordList;

//     private String websiteUrl;

//     public PasswordManager(String websiteUrl) {
//         this.websiteUrl = websiteUrl;

//         // Create the password list
//         passwordList = new ArrayList<>();
//         passwordList.add(new PasswordModel("web.com", "username1", "password1"));
//         passwordList.add(new PasswordModel("web.com", "username2", "password2"));
//         passwordList.add(new PasswordModel("web.com", "username2", "password2"));
//         passwordList.add(new PasswordModel("web.com", "username2", "password2"));
//         // Add more passwords as needed

//         // Create the main panel
//         setLayout(new BorderLayout());

//         // Create the header panel
//         JPanel headerPanel = new JPanel(new BorderLayout());
//         headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

//         JLabel websiteUrlLabel = new JLabel("Website URL: " + websiteUrl);
//         JButton backButton = new JButton("Back");
//         headerPanel.add(websiteUrlLabel, BorderLayout.CENTER);
//         headerPanel.add(backButton, BorderLayout.EAST);
//         add(headerPanel, BorderLayout.NORTH);

//         // Create the scroll pane
//         JScrollPane scrollPane = new JScrollPane();
//         add(scrollPane, BorderLayout.CENTER);

//         // Create the password panel
//         JPanel passwordPanel = new JPanel();
//         passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.Y_AXIS));
//         scrollPane.setViewportView(passwordPanel);

//         // Add the passwords to the password panel
//         for (PasswordModel password : passwordList) {
//             JPanel entryPanel = createPasswordEntryPanel(password);
//             passwordPanel.add(entryPanel);
//         }
//     }

//     private JPanel createPasswordEntryPanel(PasswordModel password) {
//         JPanel entryPanel = new JPanel(new BorderLayout());
//         entryPanel.setPreferredSize(new Dimension(400, 60));
//         entryPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

//         JLabel usernameLabel = new JLabel("Username: " + password.username);
//         JLabel passwordLabel = new JLabel("PasswordModel: " + password.password);

//         JButton editButton = new JButton("Edit");
//         JButton deleteButton = new JButton("Delete");

//         JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//         buttonPanel.add(editButton);
//         buttonPanel.add(deleteButton);

//         entryPanel.add(usernameLabel, BorderLayout.CENTER);
//         entryPanel.add(passwordLabel, BorderLayout.SOUTH);
//         entryPanel.add(buttonPanel, BorderLayout.EAST);

//         return entryPanel;
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             String websiteUrl = "www.example.com";

//             JFrame frame = new JFrame("PasswordModel Manager");
//             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//             PasswordManager passwordManager = new PasswordManager(websiteUrl);
//             frame.add(passwordManager);
//             frame.pack();
//             frame.setVisible(true);
//         });
//     }
// }

// import javax.swing.*;
// import javax.swing.border.EmptyBorder;

// import src.models.PasswordModel;

// import java.awt.*;
// import java.util.ArrayList;
// import java.util.List;

// public class PasswordManager extends JPanel {

//     private List<PasswordModel> passwordList;
//     private String websiteUrl;

//     public PasswordManager(String websiteUrl) {
//         this.websiteUrl = websiteUrl;

//         // Create the password list
//         passwordList = new ArrayList<>();
//         passwordList.add(new PasswordModel("web.com", "username1", "password1"));
//         passwordList.add(new PasswordModel("web.com", "username2", "password2"));
//         passwordList.add(new PasswordModel("web.com", "username2", "password2"));
//         passwordList.add(new PasswordModel("web.com", "username2", "password2"));
//         // Add more passwords as needed

//         // Create the main panel
//         setLayout(new BorderLayout());

//         // Create the header panel
//         JPanel headerPanel = new JPanel(new BorderLayout());
//         headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

//         JLabel websiteUrlLabel = new JLabel("Website URL: " + websiteUrl);
//         JButton backButton = new JButton("Back");
//         headerPanel.add(websiteUrlLabel, BorderLayout.CENTER);
//         headerPanel.add(backButton, BorderLayout.EAST);
//         add(headerPanel, BorderLayout.NORTH);

//         // Create the scroll pane
//         JScrollPane scrollPane = new JScrollPane();
//         add(scrollPane, BorderLayout.CENTER);

//         // Create the password panel
//         JPanel passwordPanel = new JPanel(new GridBagLayout());
//         scrollPane.setViewportView(passwordPanel);

//         GridBagConstraints gbc = new GridBagConstraints();
//         gbc.gridwidth = GridBagConstraints.REMAINDER;
//         gbc.fill = GridBagConstraints.HORIZONTAL;
//         gbc.insets = new Insets(5, 5, 5, 5);

//         // Add the passwords to the password panel
//         for (PasswordModel password : passwordList) {
//             JPanel entryPanel = createPasswordEntryPanel(password);
//             passwordPanel.add(entryPanel, gbc);
//         }
//     }

//     private JPanel createPasswordEntryPanel(PasswordModel password) {
//         JPanel entryPanel = new JPanel(new BorderLayout());
//         entryPanel.setPreferredSize(new Dimension(400, 60));
//         entryPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

//         JLabel usernameLabel = new JLabel("Username: " + password.username);
//         JLabel passwordLabel = new JLabel("PasswordModel: " + password.password);

//         JButton editButton = new JButton("Edit");
//         JButton deleteButton = new JButton("Delete");

//         JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//         buttonPanel.add(editButton);
//         buttonPanel.add(deleteButton);

//         entryPanel.add(usernameLabel, BorderLayout.WEST);
//         entryPanel.add(passwordLabel, BorderLayout.CENTER);
//         entryPanel.add(buttonPanel, BorderLayout.EAST);

//         return entryPanel;
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             String websiteUrl = "www.example.com";

//             JFrame frame = new JFrame("PasswordModel Manager");
//             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//             PasswordManager passwordManager = new PasswordManager(websiteUrl);
//             frame.add(passwordManager);
//             frame.pack();
//             frame.setVisible(true);
//         });
//     }
// }

import javax.swing.*;
import javax.swing.border.Border;

import src.utils.MyConstants;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PasswordManager extends JPanel {

    private List<Password> passwordList;
    private String websiteUrl;

    public PasswordManager(String websiteUrl) {
        this.websiteUrl = websiteUrl;

        // Create the password list
        passwordList = new ArrayList<>();
        passwordList.add(new Password("username1", "password1"));
        passwordList.add(new Password("username2", "password2"));
        System.out.println(passwordList.size());
        // Add more passwords as needed

        // Create the main panel
        setLayout(new BorderLayout());

        // Create the header panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel websiteUrlLabel = new JLabel("Website URL: " + websiteUrl);
        JButton backButton = new JButton("Back");
        headerPanel.add(websiteUrlLabel, BorderLayout.CENTER);
        headerPanel.add(backButton, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);

        // Create the scroll pane
        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);

        // Create the password panel
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(passwordPanel);

        Border entryBorder = BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK);
        // Add the passwords to the password panel
        for (Password password : passwordList) {
            JPanel entryPanel = createPasswordEntryPanel(password);
            entryPanel.setBorder(entryBorder);
            passwordPanel.add(entryPanel, BorderLayout.NORTH);
            System.out.println(password.getUsername());
        }

    }

    private JPanel createPasswordEntryPanel(Password password) {
        JPanel entryPanel = new JPanel(new BorderLayout());
        entryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel labelPanel = new JPanel(new GridLayout(2, 1));
        JLabel usernameLabel = new JLabel("Username: " + password.getUsername());
        JLabel passwordLabel = new JLabel("Password: " + password.getPassword());
        labelPanel.add(usernameLabel);
        labelPanel.add(passwordLabel);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        entryPanel.add(labelPanel, BorderLayout.CENTER);
        entryPanel.add(buttonPanel, BorderLayout.EAST);
        entryPanel.setMaximumSize(new Dimension(MyConstants.SCREEN_WIDTH, MyConstants.PASSWORD_MAX_HEIGHT));
        ;

        return entryPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String websiteUrl = "www.example.com";

            JFrame frame = new JFrame("Password Manager");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PasswordManager passwordManager = new PasswordManager(websiteUrl);
            frame.add(passwordManager);
            frame.pack();
            frame.setVisible(true);
        });
    }
}

class Password {
    private String username;
    private String password;

    public Password(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}