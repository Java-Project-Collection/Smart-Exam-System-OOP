public class Result {

    private String username;
    private int score;
    private double percentage;
    private String grade;

    public Result(String username,
                  int score,
                  double percentage,
                  String grade) {

        this.username = username;
        this.score = score;
        this.percentage = percentage;
        this.grade = grade;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {

        return username + "," +
                score + "," +
                percentage + "," +
                grade;
    }
}