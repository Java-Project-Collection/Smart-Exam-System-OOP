import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ExamFrame extends JFrame {
    private User user;
    private FileManager fm;
    private ArrayList<Question> questions;
    private int currentQuestion;
    private int score;
    private JLabel questionLabel;

    private JRadioButton option1;
    private JRadioButton option2;
    private JRadioButton option3;
    private JRadioButton option4;

    private ButtonGroup group;
    private JButton nextButton;

    public ExamFrame(User user){
        this.user=user;
        fm = new FileManager();
        questions = fm.loadQuestions();

        setTitle("Smart Exam System");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        questionLabel = new JLabel();
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(questionLabel,BorderLayout.NORTH);

        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new GridLayout(4,1));

        option1 = new JRadioButton();
        option2 = new JRadioButton();
        option3 = new JRadioButton();
        option4 = new JRadioButton();

        group = new ButtonGroup();

        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        optionPanel.add(option1);
        optionPanel.add(option2);
        optionPanel.add(option3);
        optionPanel.add(option4);

        add(optionPanel,BorderLayout.CENTER);

        nextButton = new JButton("Next");
        add(nextButton,BorderLayout.SOUTH);
        nextButton.addActionListener(e -> nextQuestion());

        loadQuestion();

        setVisible(true);
    }
    private void loadQuestion(){
        if(currentQuestion>=questions.size()){
            finishExam();
            return;
        }
        Question q = questions.get(currentQuestion);
        questionLabel.setText("Q"+(currentQuestion+1)+":"+q.getQuestionText());
        String[] options = q.getOptions();
        option1.setText(options[0]);
        option2.setText(options[1]);
        option3.setText(options[2]);
        option4.setText(options[3]);
        group.clearSelection();
    }
    private void nextQuestion(){
        int selectedAnswer = 0;

        if (option1.isSelected()) {
            selectedAnswer = 1;
        } else if (option2.isSelected()) {
            selectedAnswer = 2;
        } else if (option3.isSelected()) {
            selectedAnswer = 3;
        } else if (option4.isSelected()) {
            selectedAnswer = 4;
        }
        if (selectedAnswer != 0) {
            Question q = questions.get(currentQuestion);
            if (q.isCorrect(selectedAnswer)) {
                score += 4;
            } else {
                score -= 5;
            }
        }
        currentQuestion++;
        loadQuestion();
    }
    private void finishExam() {
        int totalMarks = questions.size() * 4;
        double percentage = ((double) score / totalMarks) * 100;
        String grade;

        if (percentage >= 90) {
            grade = "A";
        } else if (percentage >= 80) {
            grade = "B";
        } else if (percentage >= 70) {
            grade = "C";
        } else if (percentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
            Result result = new Result(user.getUsername(), score, percentage, grade);
            fm.saveResult(result);
            dispose();
            new ResultFrame(user.getUsername(), score, percentage, grade);
        }
    }
}
