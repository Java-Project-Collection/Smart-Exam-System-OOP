import java.util.ArrayList;
import java.util.Scanner;

public class ExamService {
    private FileManager fileManager;
    private Scanner sc;

    public ExamService(FileManager fileManager, Scanner sc) {
        this.fileManager = fileManager;
        this.sc = sc;
    }
    private int getValidInput() {

        while(true) {

            System.out.print("Enter Answer (1-4, 0 to skip): ");

            if(sc.hasNextInt()) {

                int answer = sc.nextInt();

                if(answer >= 0 && answer <= 4) {
                    return answer;
                }
            }

            System.out.println("Invalid Input!");
            sc.nextLine();
        }
    }
    public static String calculateGrade(int score) {

        if(score >= 90)
            return "A";

        else if(score >= 80)
            return "B";

        else if(score >= 70)
            return "C";

        else if(score >= 60)
            return "D";

        else if(score >= 50)
            return "D-";

        return "F";
    }
    public Result conductExam(Student student){
        ArrayList<Question> questions = fileManager.loadQuestions();

        int score=0;
        for(Question q : questions){
            q.displayQuestion();
            int answer = getValidInput();

            if (answer==0) {
                score+=0;
            } else if (q.isCorrect(answer)){
                score+=4;
            } else{
                score -=5;
            }
        }
        String grade = calculateGrade(score);

        Result result = new Result(student.getUsername(),score,grade);
        return result;
    }
}
