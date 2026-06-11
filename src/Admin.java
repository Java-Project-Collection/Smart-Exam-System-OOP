import java.util.Scanner;

public class Admin extends User{
    Scanner sc = new Scanner(System.in);

    public Admin (String username,String password){
        super(username,password,"Admin");
    }
    public void adminMenu() {

        while(true) {

            System.out.println("\n===== ADMIN PANEL =====");
            System.out.println("1. Add Question");
            System.out.println("2. Update Question");
            System.out.println("3. Delete Question");
            System.out.println("4. View Results");
            System.out.println("5. Logout");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    addQuestion();
                    break;

                case 2:
                    updateQuestion();
                    break;

                case 3:
                    deleteQuestion();
                    break;

                case 4:
                    viewResults();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
    public void addQuestion() {
        System.out.println("Add Question");
    }

    public void updateQuestion() {
        System.out.println("Update Question");
    }

    public void deleteQuestion() {
        System.out.println("Delete Question");
    }

    public void viewResults() {
        System.out.println("View Results");
    }
}

