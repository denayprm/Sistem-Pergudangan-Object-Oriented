package App.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class LoginSignUpGUI {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JPasswordField confirmPasswordField;

    // Declare newUsernameField at the class level
    private JTextField newUsernameField;

    private Connection connection;
    private Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new LoginSignUpGUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LoginSignUpGUI() {
        frame = new JFrame();  // Instantiate the frame
        initialize();
        setupDatabase();
    }

    private void initialize() {
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Username:");
        lblNewLabel.setBounds(50, 30, 80, 20);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Password:");
        lblNewLabel_1.setBounds(50, 70, 80, 20);
        frame.getContentPane().add(lblNewLabel_1);

        usernameField = new JTextField();
        usernameField.setBounds(150, 30, 150, 20);
        frame.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 20);
        frame.getContentPane().add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 110, 80, 25);
        frame.getContentPane().add(loginButton);

        JButton signupButton = new JButton("Sign Up");
        signupButton.setBounds(250, 110, 100, 25);
        frame.getContentPane().add(signupButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (users.containsKey(username) && users.get(username).equals(password)) {
                    openDashboard();
                } else {
                    JOptionPane.showMessageDialog(frame, "Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showSignUpDialog();
            }
        });

        frame.setVisible(true);
    }

    private void setupDatabase() {
        try {
            // Update these variables with your actual database details
            String dbUrl = "jdbc:mysql://localhost:3306/LoginSignUp";
            String dbUser = "admin";
            String dbPassword = "admin";

            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            createTableIfNotExists();
            loadUsersFromDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists() {
        try (Statement statement = connection.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(50) UNIQUE, email VARCHAR(100), password VARCHAR(50));";
            statement.executeUpdate(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadUsersFromDatabase() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                users.put(username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addUserToDatabase(String username, String email, String password) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username, email, password) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showSignUpDialog() {
        JFrame signUpFrame = new JFrame();
        signUpFrame.setBounds(100, 100, 400, 300);
        signUpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signUpFrame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Username:");
        lblNewLabel.setBounds(50, 30, 80, 20);
        signUpFrame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("Email:");
        lblNewLabel_2.setBounds(50, 70, 80, 20);
        signUpFrame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_1 = new JLabel("Password:");
        lblNewLabel_1.setBounds(50, 110, 80, 20);
        signUpFrame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_3 = new JLabel("Confirm Password:");
        lblNewLabel_3.setBounds(50, 150, 120, 20);
        signUpFrame.getContentPane().add(lblNewLabel_3);

        // Use the class-level newUsernameField
        newUsernameField = new JTextField();
        newUsernameField.setBounds(180, 30, 150, 20);
        signUpFrame.getContentPane().add(newUsernameField);
        newUsernameField.setColumns(10);

        emailField = new JTextField();
        emailField.setBounds(180, 70, 150, 20);
        signUpFrame.getContentPane().add(emailField);
        emailField.setColumns(10);

        JPasswordField newPasswordField = new JPasswordField();
        newPasswordField.setBounds(180, 110, 150, 20);
        signUpFrame.getContentPane().add(newPasswordField);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(180, 150, 150, 20);
        signUpFrame.getContentPane().add(confirmPasswordField);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(150, 190, 100, 25);
        signUpFrame.getContentPane().add(signUpButton);

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newUsername = newUsernameField.getText();
                String email = emailField.getText();
                String newPassword = new String(newPasswordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (newPassword.equals(confirmPassword) && !users.containsKey(newUsername)) {
                    addUserToDatabase(newUsername, email, newPassword);
                    users.put(newUsername, newPassword);
                    signUpFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(signUpFrame, "Passwords do not match or username is not unique", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        signUpFrame.setVisible(true);
    }

    private void openDashboard() {
        // Code to open the dashboard goes here
        // You can implement the dashboard UI and functionality
        // For now, let's just print a message
        System.out.println("Dashboard opened");
    }
}
