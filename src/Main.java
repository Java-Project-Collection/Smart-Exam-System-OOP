import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FileManager fm = new FileManager();
        AuthenticationService auth =
                new AuthenticationService(fm, sc);

        ExamService exam =
                new ExamService(fm, sc);

        while (true) {

            System.out.println("\n=================================");
            System.out.println("       SMART EXAM SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("=================================");

            System.out.print("Enter Choice: ");

            int choice;

            if (sc.hasNextInt()) {

                choice = sc.nextInt();
                sc.nextLine();

            } else {

                System.out.println("Invalid Input!");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:

                    auth.registerStudent();
                    break;

                case 2:

                    User user = auth.login();

                    if (user != null) {

                        Result previousResult =
                                fm.getResult(
                                        user.getUsername()
                                );

                        if (previousResult != null) {

                            System.out.println(
                                    "\nYou have already attempted the exam!");

                            previousResult.displayResult();
                        }

                        else {

                            Student student =
                                    new Student(
                                            user.getUsername(),
                                            user.getPassword()
                                    );

                            Result result =
                                    exam.conductExam(student);

                            if (result != null) {

                                result.displayResult();
                            }
                        }
                    }

                    break;

                case 3:

                    System.out.println(
                            "\nThank You For Using Smart Exam System!");

                    System.out.println(
                            "Good Bye!");

                    sc.close();
                    return;

                default:

                    System.out.println(
                            "\nInvalid Choice!");
            }
        }
    }
}