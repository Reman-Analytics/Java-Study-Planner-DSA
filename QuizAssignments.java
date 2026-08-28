import java.util.Scanner;

public class QuizAssignments{

    private String[] assignmentName = new String[20];
    private int assignmentCount = 0;

    private String[] quiz = new String[20];
    private int front = 0;
    private int rear = -1;
    private int capacity = 20;

    Scanner input = new Scanner(System.in);


    public void showQuizAssignments() {

        int choice;

        do {

            System.out.println("\n==============================================");
            System.out.println("\t\tQUIZ & ASSIGNMENTS");
            System.out.println("\t\t------------------");
            System.out.println("1. Add Assignment");
            System.out.println("2. Display Assignments");
            System.out.println("3. Search Assignment");
            System.out.println("4. Add Quiz");
            System.out.println("5. Show Upcoming Quiz");
            System.out.println("6. Back to Dashboard");
            System.out.println("----------------------------------------------");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch(choice) {

                case 1:
                    addAssignment();
                    break;

                case 2:
                    displayAssignments();
                    break;

                case 3:
                    searchAssignment();
                    break;

                case 4:
                    addQuiz();
                    break;

                case 5:
                    showUpcomingQuiz();
                    break;

                case 6:
                    System.out.println("\nReturning to Dashboard...");
                    return;

                default:
                    System.out.println("Invalid Choice!");

            }

        } while(true);
    }

    // Add Assignment
    public void addAssignment() {

        if (assignmentCount == 20) {

            System.out.println("\nAssignment List is Full!");
            return;
        }

        System.out.print("Enter Assignment Name: ");
        assignmentName[assignmentCount] = input.nextLine();

        assignmentCount++;

        System.out.println("\nAssignment Added Successfully!");
    }

    // Display Assignments
    public void displayAssignments() {

        if (assignmentCount == 0) {

            System.out.println("\nNo Assignments Found!");
            return;
        }

        System.out.println("\n========== Assignments ==========");

        for (int i = 0; i < assignmentCount; i++) {

            System.out.println((i + 1) + ". " + assignmentName[i]);

        }
    }

    // Search Assignment
    public void searchAssignment() {

        if (assignmentCount == 0) {

            System.out.println("\nNo Assignments Found!");
            return;
        }

        System.out.print("Enter Assignment Name to Search: ");
        String search = input.nextLine();

        boolean found = false;

        for (int i = 0; i < assignmentCount; i++) {

            if (assignmentName[i].equalsIgnoreCase(search)) {

                System.out.println("\nAssignment Found!");
                System.out.println("Assignment : " + assignmentName[i]);

                found = true;
                break;
            }
        }

        if (!found) {

            System.out.println("\nAssignment Not Found!");
        }

    }

    // Add Quiz (Enqueue)
    public void addQuiz() {

        if (rear == capacity - 1) {

            System.out.println("\nQuiz Queue is Full!");
            return;
        }

        System.out.print("Enter Quiz Name: ");
        String quizName = input.nextLine();

        rear++;
        quiz[rear] = quizName;

        System.out.println("\nQuiz Added Successfully!");
    }

    // Show Upcoming Quiz (Dequeue)
    public void showUpcomingQuiz() {

        if (front > rear) {

            System.out.println("\nNo Upcoming Quiz!");
            return;
        }

        System.out.println("\n========== Upcoming Quiz ==========");
        System.out.println("Quiz : " + quiz[front]);

        front++;

        System.out.println("\nQuiz Removed From Queue!");
    }
}