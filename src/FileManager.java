import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private final String USER_FILE = "user.txt";
    private final String QUESTION_FILE = "question.txt";
    private final String RESULT_FILE = "result.txt";

    public FileManager() {

        createFile(USER_FILE);
        createFile(QUESTION_FILE);
        createFile(RESULT_FILE);
    }

    private void createFile(String fileName) {

        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            System.out.println("Error creating file: " + fileName);
        }
    }

    //  USER METHODS

    public void saveUser(User user) {

        try (BufferedWriter bw =
                     new BufferedWriter(
                             new FileWriter(USER_FILE, true))) {
            bw.write(user.toString());
            bw.newLine();
        } catch (Exception e) {
            System.out.println("Error saving user");
        }
    }

    public ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    users.add(
                            new Student(
                                    parts[0],
                                    parts[1]
                            )
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading users");
        }
        return users;
    }
    public boolean usernameExists(String username) {
        ArrayList<User> users = loadUsers();
        for (User user : users) {
            if (user.getUsername()
                    .equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    // QUESTION METHODS

    public void saveQuestion(Question question) {
        try (BufferedWriter bw =
                     new BufferedWriter(
                             new FileWriter(QUESTION_FILE, true))) {
            bw.write(question.toString());
            bw.newLine();
        } catch (Exception e) {
            System.out.println("Error saving question");
        }
    }
    public ArrayList<Question> loadQuestions() {
        ArrayList<Question> questions =
                new ArrayList<>();
        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(QUESTION_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String[] options = {
                            parts[1],
                            parts[2],
                            parts[3],
                            parts[4]
                    };
                    questions.add(
                            new Question(
                                    parts[0],
                                    options,
                                    Integer.parseInt(parts[5])
                            )
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading questions");
        }
        return questions;
    }

    //  RESULT METHODS

    public void saveResult(Result result) {
        try (BufferedWriter bw =
                     new BufferedWriter(
                             new FileWriter(RESULT_FILE, true))) {
            bw.write(result.toString());
            bw.newLine();
        } catch (Exception e) {
            System.out.println("Error saving result");
        }
    }
    public boolean hasAttemptedExam(String username) {
        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(RESULT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0]
                        .equalsIgnoreCase(username)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error checking result");
        }
        return false;
    }
    public Result getResult(String username) {
        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(RESULT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4 &&
                        parts[0].equalsIgnoreCase(username)) {
                    return new Result(
                            parts[0],
                            Integer.parseInt(parts[1]),
                            Double.parseDouble(parts[2]),
                            parts[3]
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading result");
        }
        return null;
    }
}