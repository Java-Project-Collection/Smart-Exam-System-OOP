import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    private FileManager fm;
    private AuthenticationService auth;

    public RegisterFrame(){
        fm = new FileManager();
        auth = new AuthenticationService(fm,null);

        setTitle("Student Registration");
        setSize(400,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,2,10,10));

        add(new JLabel("Username"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton registerButton = new JButton("Register");
        add(registerButton);

        registerButton.addActionListener(e -> registerStudent());

        setVisible(true);
    }
    private void registerStudent(){
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if(username.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(this,"Fill all Fields");
            return;
        }
        boolean success =
                auth.registerStudent(username, password);
        if (success){
            JOptionPane.showMessageDialog(this,"Registration Successfully");
        }else {
            JOptionPane.showMessageDialog(this,"Username Already Exists");
        }
    }
}
