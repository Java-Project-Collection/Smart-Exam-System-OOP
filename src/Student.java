import java.util.Scanner;

public class Student extends User {
    Scanner sc = new Scanner(System.in);

    public Student (String username,String password){
        super(username,password,"Student");
    }

    public void studentMenu(){
        while (true) {
            System.out.println("\n===== Student Panel =====");
            System.out.println("1. Start exam");
            System.out.println("2. View result");
            System.out.println("3. Logout");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    startExam();
                    break;

                case 2:
                    viewResult();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
    public void startExam(){
        System.out.println("Starting Exam......");
    }
    public void viewResult(){
        System.out.println("Viewing result");
    }

}
