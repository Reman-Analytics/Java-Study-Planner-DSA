import java.util.Scanner;

public class SessionHistory {

    // Nested Class
    static class StudySession {

        int sessionID;
        String sessionName;
        StudySession next;

        public StudySession(int sessionID, String sessionName) {
            this.sessionID = sessionID;
            this.sessionName = sessionName;
            this.next = null;
        }
    }

    // Top Pointer for Stack
    static StudySession top = null;

    public static void sessionMenu() {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n====== STUDY SESSION HISTORY ======");

            System.out.println("\nCRUD OPERATIONS");
            System.out.println("1. Add Study Session");
            System.out.println("2. View All Sessions");
            System.out.println("3. Update Study Session");
            System.out.println("4. Delete Study Session");

            System.out.println("\nSTACK OPERATIONS");
            System.out.println("5. Show Session History");
            System.out.println("6. Remove Latest Session (POP)");
            System.out.println("7. View Latest Session (PEEK)");
            System.out.println("8. Back");

            System.out.print("\nEnter Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addSession(sc);
                    break;

                case 2:
                    viewAllSessions();
                    break;

                case 3:
                    updateSession(sc);
                    break;

                case 4:
                    deleteSession(sc);
                    break;

                case 5:
                    showSessionHistory();
                    break;

                case 6:
                    removeLatestSession();
                    break;

                case 7:
                    viewLatestSession();
                    break;

                case 8:
                    System.out.println("Returning...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 8);
    }

    // CREATE + PUSH
    public static void addSession(Scanner sc) {

        System.out.print("Enter Session ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Session Name: ");
        String name = sc.nextLine();

        StudySession newSession = new StudySession(id, name);

        if (top == null) {
            top = newSession;
        } else {
            newSession.next = top;
            top = newSession;
        }

        System.out.println("Session Added Successfully!");
    }

    // READ
    public static void viewAllSessions() {

        if (top == null) {
            System.out.println("No Sessions Available.");
            return;
        }

        StudySession temp = top;

        while (temp != null) {

            System.out.println("----------------------");
            System.out.println("Session ID   : " + temp.sessionID);
            System.out.println("Session Name : " + temp.sessionName);

            temp = temp.next;
        }
    }

    // UPDATE
    public static void updateSession(Scanner sc) {

        if (top == null) {
            System.out.println("No Sessions Available.");
            return;
        }

        System.out.print("Enter Session ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        StudySession temp = top;

        while (temp != null) {

            if (temp.sessionID == id) {

                System.out.print("Enter New Session Name: ");
                temp.sessionName = sc.nextLine();

                System.out.println("Session Updated Successfully!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Session Not Found.");
    }

    // DELETE
    public static void deleteSession(Scanner sc) {

        if (top == null) {
            System.out.println("No Sessions Available.");
            return;
        }

        System.out.print("Enter Session ID to Delete: ");
        int id = sc.nextInt();

        // Delete Top Node
        if (top.sessionID == id) {

            top = top.next;
            System.out.println("Session Deleted Successfully!");
            return;
        }

        StudySession current = top;
        StudySession previous = null;

        while (current != null) {

            if (current.sessionID == id) {

                previous.next = current.next;
                System.out.println("Session Deleted Successfully!");
                return;
            }

            previous = current;
            current = current.next;
        }

        System.out.println("Session Not Found.");
    }

    // STACK TRAVERSAL
    public static void showSessionHistory() {

        if (top == null) {
            System.out.println("No Session History Available.");
            return;
        }

        System.out.println("\nLatest Sessions First:");

        StudySession temp = top;

        while (temp != null) {

            System.out.println("----------------------");
            System.out.println("Session ID   : " + temp.sessionID);
            System.out.println("Session Name : " + temp.sessionName);

            temp = temp.next;
        }
    }

    // POP
    public static void removeLatestSession() {

        if (top == null) {
            System.out.println("No Session Available.");
            return;
        }

        System.out.println("Latest Session Removed: "
                + top.sessionName);

        top = top.next;
    }

    // PEEK
    public static void viewLatestSession() {

        if (top == null) {
            System.out.println("No Session Available.");
            return;
        }

        System.out.println("\nLatest Session:");
        System.out.println("Session ID   : " + top.sessionID);
        System.out.println("Session Name : " + top.sessionName);
    }
}