import java.util.Scanner;

public class CourseRecommendation {

    // Nested Class
    static class Course {

        String currentCourse;
        String nextCourse;
        Course next;

        public Course(String currentCourse, String nextCourse) {
            this.currentCourse = currentCourse;
            this.nextCourse = nextCourse;
            this.next = null;
        }
    }

    // Head Pointer
    static Course head = null;

    public static void courseMenu() {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n========== COURSE RECOMMENDATION ==========");

            System.out.println("\nCRUD OPERATIONS");
            System.out.println("1. Add Course Relation");
            System.out.println("2. View All Course Relations");
            System.out.println("3. Update Course Relation");
            System.out.println("4. Delete Course Relation");

            System.out.println("\nGRAPH OPERATIONS");
            System.out.println("5. Recommend Next Course");
            System.out.println("6. Display Course Graph");

            System.out.println("7. Back");

            System.out.print("\nEnter Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addCourse(sc);
                    break;

                case 2:
                    viewCourses();
                    break;

                case 3:
                    updateCourse(sc);
                    break;

                case 4:
                    deleteCourse(sc);
                    break;

                case 5:
                    recommendNextCourse(sc);
                    break;

                case 6:
                    displayGraph();
                    break;

                case 7:
                    System.out.println("Returning...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);
    }

    // CREATE
    public static void addCourse(Scanner sc) {

        System.out.print("Enter Current Course: ");
        String current = sc.nextLine();

        System.out.print("Enter Next Course: ");
        String nextCourse = sc.nextLine();

        Course newCourse = new Course(current, nextCourse);

        if (head == null) {
            head = newCourse;
        } else {

            Course temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newCourse;
        }

        System.out.println("Course Relation Added Successfully!");
    }

    // READ
    public static void viewCourses() {

        if (head == null) {
            System.out.println("No Course Relations Found.");
            return;
        }

        Course temp = head;

        while (temp != null) {

            System.out.println("--------------------------");
            System.out.println(
                    temp.currentCourse + " --> " + temp.nextCourse);

            temp = temp.next;
        }
    }

    // UPDATE
    public static void updateCourse(Scanner sc) {

        if (head == null) {
            System.out.println("No Course Relations Found.");
            return;
        }

        System.out.print("Enter Current Course to Update: ");
        String courseName = sc.nextLine();

        Course temp = head;

        while (temp != null) {

            if (temp.currentCourse.equalsIgnoreCase(courseName)) {

                System.out.print("Enter New Next Course: ");
                temp.nextCourse = sc.nextLine();

                System.out.println("Course Updated Successfully!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Course Not Found.");
    }

    // DELETE
    public static void deleteCourse(Scanner sc) {

        if (head == null) {
            System.out.println("No Course Relations Found.");
            return;
        }

        System.out.print("Enter Current Course to Delete: ");
        String courseName = sc.nextLine();

        // Delete Head
        if (head.currentCourse.equalsIgnoreCase(courseName)) {

            head = head.next;

            System.out.println("Course Deleted Successfully!");
            return;
        }

        Course current = head;
        Course previous = null;

        while (current != null) {

            if (current.currentCourse.equalsIgnoreCase(courseName)) {

                previous.next = current.next;

                System.out.println("Course Deleted Successfully!");
                return;
            }

            previous = current;
            current = current.next;
        }

        System.out.println("Course Not Found.");
    }

    // GRAPH OPERATION
    public static void recommendNextCourse(Scanner sc) {

        if (head == null) {
            System.out.println("No Course Graph Available.");
            return;
        }

        System.out.print("Enter Completed Course: ");
        String completedCourse = sc.nextLine();

        Course temp = head;

        while (temp != null) {

            if (temp.currentCourse
                    .equalsIgnoreCase(completedCourse)) {

                System.out.println("\nRecommended Next Course:");
                System.out.println(temp.nextCourse);
                return;
            }

            temp = temp.next;
        }

        System.out.println("No Recommendation Available.");
    }

    // DISPLAY GRAPH
    public static void displayGraph() {

        if (head == null) {
            System.out.println("No Course Graph Available.");
            return;
        }

        System.out.println("\nCourse Graph:");

        Course temp = head;

        while (temp != null) {

            System.out.println(
                    temp.currentCourse + " --> " + temp.nextCourse);

            temp = temp.next;
        }
    }
}