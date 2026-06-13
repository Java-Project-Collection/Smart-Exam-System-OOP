public class Result {

    private String username;
    private int score;
    private String grade;

    public Result(String username, int score, String grade) {
        this.username = username;
        this.score = score;
        this.grade = grade;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public String getGrade() {
        return grade;
    }

    public void displayResult() {

        System.out.println("\n=================================");
        System.out.println("            RESULT");
        System.out.println("=================================");
        System.out.println("Student : " + username);
        System.out.println("Score   : " + score);
        System.out.println("Grade   : " + grade);
        System.out.println("=================================");
    }

    @Override
    public String toString() {
        return username + "," + score + "," + grade;
    }
}