import java.util.ArrayList;
import java.util.Scanner;

public class ExamService {

    private FileManager fm;
    private Scanner sc;

    public ExamService(FileManager fm, Scanner sc) {
        this.fm = fm;
        this.sc = sc;
    }

    private int getAnswer() {
        while (true) {
            System.out.print("\nEnter Answer (1-4, 0 = Skip): ");
            if (sc.hasNextInt()) {
                int answer = sc.nextInt();
                sc.nextLine();
                if (answer >= 0 && answer <= 4) {
                    return answer;
                }
            }
            else {
                sc.nextLine();
            }
            System.out.println("Invalid Input! Try Again.");
        }
    }

    private String calculateGrade(double percentage) {
        if (percentage >= 85) {
            return "A";
        } else if (percentage >= 80) {
            return "A-";
        } else if (percentage >= 75) {
            return "B+";
        } else if (percentage >= 70) {
            return "B";
        }else if (percentage >= 65) {
            return "B-";
        }else if (percentage >= 61) {
            return "C+";
        }else if (percentage >= 58) {
            return "C";
        }else if (percentage >= 55) {
            return "C-";
        }else if (percentage >= 50) {
            return "D";
        }else {
            return "F";
        }
    }

    public Result conductExam(Student student) {
        ArrayList<Question> questions = fm.loadQuestions();

        if (questions.isEmpty()) {
            System.out.println(
                    "\nNo Questions Available!");
            return null;
        }

        System.out.println("\n=================================");
        System.out.println("          EXAM STARTED");
        System.out.println("=================================");
        System.out.println("Correct Answer : +4 Marks");
        System.out.println("Wrong Answer   : -5 Marks");
        System.out.println("Skipped Answer :  0 Marks");
        System.out.println("=================================");

        int score = 0;
        int questionNumber = 1;

        for (Question q : questions) {
            System.out.println("\n---------------------------------");
            System.out.println("Question " + questionNumber++);
            System.out.println("---------------------------------");

            q.displayQuestion();

            int answer = getAnswer();
            if (answer == 0){
                System.out.println("Question Skipped!");
                continue;
            }

            if (q.isCorrect(answer)){
                score += 4;
                System.out.println("Correct Answer! (+4)");
            }
            else {
                score -= 5;
                System.out.println("Wrong Answer! (-5)");
            }
        }

        double maxMarks = questions.size() * 4.0;

        double percentage = (score * 100.0) / maxMarks;

        if (percentage < 0) {
            percentage = 0;
        }

        String grade = calculateGrade(percentage);

        Result result = new Result(student.getUsername(), score,percentage,grade);

        fm.saveResult(result);

        System.out.println("\n=================================");
        System.out.println("         EXAM COMPLETED");
        System.out.println("=================================");
        System.out.printf("Percentage : %.2f%%\n", percentage);
        System.out.println("Grade      : " + grade);
        System.out.println("=================================");

        return result;
    }
}