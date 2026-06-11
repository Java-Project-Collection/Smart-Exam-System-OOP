import java.util.ArrayList;
import java.util.Scanner;

public class AuthenticationService {
    private FileManager fileManager;
    private Scanner sc;

    public AuthenticationService(FileManager fileManager, Scanner sc) {        this.fileManager = fileManager;
        this.sc = sc;
    }
    public void registerStudent(){
        System.out.println("Enter Username: ");
        String username = sc.nextLine();
        if(fileManager.usernameExists(username)){
            System.out.println("Username Already Exists!");
            return;
        }
        System.out.println("Enter Password: ");
        String password = sc.nextLine();

        Student student= new Student(username,password);
        fileManager.saveUser(student);

        System.out.println("Registration Successful!");
    }
    public void registerAdmin(){
        System.out.println("Enter AdminName: ");
        String adminName = sc.nextLine();
        if (fileManager.usernameExists(adminName)){
            System.out.println("Admin Already Exists!");
            return;
        }
        System.out.println("Enter password:  ");
        String password = sc.nextLine();

        Admin admin = new Admin(adminName,password);
        fileManager.saveUser(admin);

        System.out.println("Admin created Successfully!");
    }
    public User login(){
        System.out.println("Enter username: ");
        String username= sc.nextLine();

        System.out.println("Enter password: ");
        String password = sc.nextLine();

        ArrayList<User>users =  fileManager.loadUsers();

        for (User user : users) {

            if (user.getUsername().equals(username)
                    &&
                    user.getPassword().equals(password)) {

                System.out.println(
                        "Login Successful!");

                return user;
            }
        }
        System.out.println(
                "Invalid Username or Password.");

        return null;
    }

}
