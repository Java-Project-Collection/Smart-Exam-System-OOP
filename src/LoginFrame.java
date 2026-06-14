import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    private FileManager fm;
    private AuthenticationService auth;

    public LoginFrame() {
        fm = new FileManager();
        auth = new AuthenticationService(fm, null);

        setTitle("Smart Exam System");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        add(loginButton);
        add(registerButton);

        loginButton.addActionListener(e -> login());
        registerButton.addActionListener(
                e -> new RegisterFrame()
        );
        setVisible(true);
    }
    private void login() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());
        User user = auth.login(username, password);

        if (user == null) {
            JOptionPane.showMessageDialog(this, "Invalid Username or Password!");
            return;
        }
        Result oldResult = fm.getResult(user.getUsername());
        dispose();
        if (oldResult != null) {
            new ResultFrame(oldResult.getUsername(), oldResult.getScore(), oldResult.getPercentage(), oldResult.getGrade());
        } else {
            new ExamFrame(user);
        }
    }
}