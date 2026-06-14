import javax.swing.*;
import java.awt.*;

public class ResultFrame extends JFrame {

    public ResultFrame(String username, int score, double percentage, String grade) {

        setTitle("Exam Result");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1, 10, 10));

        JLabel title = new JLabel("SMART EXAM RESULT", SwingConstants.CENTER);
        JLabel userLabel = new JLabel("Student: " + username, SwingConstants.CENTER);

        JLabel scoreLabel = new JLabel("Score: " + score, SwingConstants.CENTER);
        JLabel percentageLabel = new JLabel("Percentage: " + String.format("%.2f", percentage) + "%", SwingConstants.CENTER);
        JLabel gradeLabel = new JLabel("Grade: " + grade, SwingConstants.CENTER);
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));

        add(title);
        add(userLabel);
        add(scoreLabel);
        add(percentageLabel);
        add(gradeLabel);
        add(exitButton);

        setVisible(true);
    }
}