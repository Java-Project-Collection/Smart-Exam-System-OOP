import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private final String USER_FILE = "user.txt";
    private final String QUESTION_FILE = "question.txt";
    private final String ANSWER_FILE = "answer.txt";
    private final String RESULT_FILE = "result.txt";

    public FileManager() {

        createFile(USER_FILE);
        createFile(QUESTION_FILE);
        createFile(ANSWER_FILE);
        createFile(RESULT_FILE);
    }

    // Create file if it does not exist
    private void createFile(String fileName) {

        try {

            File file = new File(fileName);

            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {

            System.out.println("Error while creating file: " + fileName);
        }
    }

    // ================= USER METHODS =================

    public void saveUser(User user) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true))) {

            writer.write(user.toString());
            writer.newLine();

        } catch (IOException e) {

            System.out.println("Error saving user.");
        }
    }

    public ArrayList<User> loadUsers() {

        ArrayList<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length != 3) {
                    continue;
                }

                String username = parts[0];
                String password = parts[1];
                String role = parts[2];

                if (role.equalsIgnoreCase("Admin")) {
                    users.add(new Admin(username, password));
                } else {
                    users.add(new Student(username, password));
                }
            }

        } catch (IOException e) {

            System.out.println("Error loading users.");
        }

        return users;
    }

    public boolean usernameExists(String username) {

        ArrayList<User> users = loadUsers();

        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }

        return false;
    }

    // ================= QUESTION METHODS =================

    public void saveQuestion(Question question) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(
                                     QUESTION_FILE, true))) {

            writer.write(question.toString());
            writer.newLine();

        } catch (IOException e) {

            System.out.println("Error saving question.");
        }
    }

    public ArrayList<Question> loadQuestions() {

        ArrayList<Question> questions =
                new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(
                                     QUESTION_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length != 6) {
                    continue;
                }

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

        } catch (Exception e) {

            System.out.println("Error loading questions.");
        }

        return questions;
    }

    public void overwriteQuestions(
            ArrayList<Question> questions) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(
                                     QUESTION_FILE))) {

            for (Question question : questions) {

                writer.write(question.toString());
                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println("Error updating questions.");
        }
    }

    // ================= RESULT METHODS =================

    public void saveResult(Result result) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(
                                     RESULT_FILE, true))) {

            writer.write(result.toString());
            writer.newLine();

        } catch (IOException e) {

            System.out.println("Error saving result.");
        }
    }

    public ArrayList<Result> loadResults() {

        ArrayList<Result> results =
                new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(
                                     RESULT_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length != 3) {
                    continue;
                }

                results.add(
                        new Result(
                                parts[0],
                                Integer.parseInt(parts[1]),
                                parts[2]
                        )
                );
            }

        } catch (IOException e) {

            System.out.println("Error loading results.");
        }

        return results;
    }

    public boolean hasAttemptedExam(
            String username) {

        ArrayList<Result> results =
                loadResults();

        for (Result result : results) {

            if (result.getUsername()
                    .equalsIgnoreCase(username)) {

                return true;
            }
        }

        return false;
    }

    public Result getResult(
            String username) {

        ArrayList<Result> results =
                loadResults();

        for (Result result : results) {

            if (result.getUsername()
                    .equalsIgnoreCase(username)) {

                return result;
            }
        }

        return null;
    }

    // ================= ANSWER METHODS =================

    public void saveAnswers(
            String username,
            int[] answers,
            int totalQuestions) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(
                                     ANSWER_FILE, true))) {

            writer.write(username);

            for (int i = 0;
                 i < totalQuestions;
                 i++) {

                writer.write("," + answers[i]);
            }

            writer.newLine();

        } catch (IOException e) {

            System.out.println("Error saving answers.");
        }
    }
}