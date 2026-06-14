import java.util.ArrayList;
import java.util.Scanner;

public class AuthenticationService {

    private FileManager fm;
    private Scanner sc;

    public AuthenticationService(FileManager fm, Scanner sc) {
        this.fm = fm;
        this.sc = sc;
    }


    public void registerStudent() {

        System.out.println("\n=================================");
        System.out.println("      STUDENT REGISTRATION");
        System.out.println("=================================");

        System.out.print("Enter Username: ");
        String username = sc.nextLine().trim();

        if (fm.usernameExists(username)) {

            System.out.println("\nUsername already exists!");
            return;
        }

        System.out.print("Enter Password: ");
        String password = sc.nextLine().trim();

        Student student =
                new Student(username, password);

        fm.saveUser(student);

        System.out.println("\nRegistration Successful!");
    }

    public User login() {

        System.out.println("\n=================================");
        System.out.println("          LOGIN");
        System.out.println("=================================");

        System.out.print("Enter Username: ");
        String username = sc.nextLine().trim();

        System.out.print("Enter Password: ");
        String password = sc.nextLine().trim();

        ArrayList<User> users =
                fm.loadUsers();

        for (User user : users) {

            if (user.getUsername()
                    .equalsIgnoreCase(username)
                    &&
                    user.getPassword()
                            .equals(password)) {

                System.out.println(
                        "\nLogin Successful!");

                return user;
            }
        }

        System.out.println(
                "\nInvalid Username or Password!");

        return null;
    }
    public User login(
            String username,
            String password) {

        ArrayList<User> users =
                fm.loadUsers();

        for (User user : users) {

            if (user.getUsername()
                    .equalsIgnoreCase(username)
                    &&
                    user.getPassword()
                            .equals(password)) {

                return user;
            }
        }

        return null;
    }
    public boolean registerStudent(
            String username,
            String password) {

        if (fm.usernameExists(username)) {
            return false;
        }

        Student student =
                new Student(username, password);

        fm.saveUser(student);

        return true;
    }
}