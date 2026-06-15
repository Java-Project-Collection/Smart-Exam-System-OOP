import javax.swing.*;
import java.awt.*;

public class WelcomeFrame extends JFrame {
    public WelcomeFrame(){

        setTitle("Smart Exam System");
        setSize(400,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4,1,10,10));
        JLabel title= new JLabel("Smart Exam System",SwingConstants.CENTER);

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        JButton exitButton = new JButton("Exit");

        add(title);
        add(loginButton);
        add(registerButton);
        add(exitButton);

        loginButton.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });
        registerButton.addActionListener(e -> {
            dispose();
            new RegisterFrame();
        });
        exitButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(this,"Exit Application?","confirmExit",JOptionPane.YES_NO_CANCEL_OPTION);
            if(choice==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        });
        setVisible(true);
    }
}
