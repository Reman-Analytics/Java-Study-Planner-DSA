import java.util.Scanner;

public class Dashboard {

    public void showDashboard() {

        Scanner input = new Scanner(System.in);

        int choice;

        do {

            System.out.println("==============================================");
            System.out.println("\n\t\tDASHBOARD");
            System.out.println("\t\t---------\n");

            System.out.println("1. Go to Performance");
            System.out.println("2. Planner");
            System.out.println("3. Daily Schedule");
            System.out.println("4. Pending Tasks");
            System.out.println("5. Quiz & Assignments");
            System.out.println("6. Focus Mode");
            System.out.println("7. Learning Path");
            System.out.println("8. Back to Main Menu");

            System.out.println("----------------------------------------------");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nOpening Performance...");
                    Performance p = new Performance();
                    p.showPerformance();
                    break;

                case 2:
                    System.out.println("\nOpening Planner...");
                    Planner pl = new Planner();
                    pl.showPlanner();
                    break;

                case 3:
                    System.out.println("\nOpening Daily Schedule...");
                    DailySchedule ds = new DailySchedule();
                    ds.showDailySchedule();
                    break;

                case 4:
                    System.out.println("\nOpening Pending Tasks...");
                    PendingTask pt = new PendingTask();
                    pt.showPendingTask();
                    break;

                case 5:
                    System.out.println("\nOpening Quiz & Assignments...");
                    QuizAssignments qa = new QuizAssignments();
                    qa.showQuizAssignments();
                    break;

                case 6:
                    System.out.println("\nOpening Focus Mode...");
                    FocusMode fm = new FocusMode();
                    fm.showFocusMode();
                    break;

                case 7:
                    System.out.println("\nOpening Learning Path...");
                    LearningPath lp = new LearningPath();
                    lp.pathMenu();
                    break;

                case 8:
                    System.out.println("\nReturning to Main Menu...");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 8);
    }
}