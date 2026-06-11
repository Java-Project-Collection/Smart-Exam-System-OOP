public class Question {
    private String questionText;
    private String[] options;
    private int correctAnswer;

    public Question(String questionText, String[] options,int correctAnswer ) {
        this.correctAnswer = correctAnswer;
        this.options = options;
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void displayQuestion(){
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i+1)+". "+options[i]);
        }
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctAnswer;
    }

    @Override
    public String toString() {
        return questionText + "," +
                options[0] + "," +
                options[1] + "," +
                options[2] + "," +
                options[3] + "," +
                correctAnswer;
    }
}
