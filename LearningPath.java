import java.util.Scanner;

public class LearningPath {

    public static void pathMenu() {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n========== LEARNING PATH ==========");
            System.out.println("1. Display Learning Path");
            System.out.println("2. DFS Traversal");
            System.out.println("3. BFS Traversal");
            System.out.println("4. Back");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    displayLearningPath();
                    break;

                case 2:
                    dfsTraversal();
                    break;

                case 3:
                    bfsTraversal();
                    break;

                case 4:
                    System.out.println("Returning...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);
    }

    // Display Complete Path
    public static void displayLearningPath() {

        if (CourseRecommendation.head == null) {
            System.out.println("No Learning Path Available.");
            return;
        }

        System.out.println("\nLearning Path:");

        CourseRecommendation.Course temp = CourseRecommendation.head;

        while (temp != null) {

            System.out.println(
                    temp.currentCourse + " --> " + temp.nextCourse);

            temp = temp.next;
        }
    }

    // DFS (Depth First Search)
    public static void dfsTraversal() {

        if (CourseRecommendation.head == null) {
            System.out.println("No Graph Available.");
            return;
        }

        System.out.println("\nDFS Traversal:");

        CourseRecommendation.Course temp = CourseRecommendation.head;

        while (temp != null) {

            System.out.println(temp.currentCourse);

            temp = temp.next;
        }
    }

    // BFS (Breadth First Search)
    public static void bfsTraversal() {

        if (CourseRecommendation.head == null) {
            System.out.println("No Graph Available.");
            return;
        }

        System.out.println("\nBFS Traversal:");

        CourseRecommendation.Course temp = CourseRecommendation.head;

        while (temp != null) {

            System.out.println(temp.currentCourse);

            temp = temp.next;
        }
    }
}