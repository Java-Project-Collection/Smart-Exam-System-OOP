public class Result {

    private String username;
    private int score;
    private String grade;

    // Constructor
    public Result(String username, int score, String grade) {
        this.username = username;
        this.score = score;
        this.grade = grade;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public String getGrade() {
        return grade;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Display Result
    public void displayResult() {

        System.out.println("\n===== RESULT =====");
        System.out.println("Username: " + username);
        System.out.println("Score: " + score);
        System.out.println("Grade: " + grade);
    }

    @Override
    public String toString() {
        return username + "," + score + "," + grade;
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
}
