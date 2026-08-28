import java.util.Scanner;

public class FocusMode {

    public void showFocusMode() {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n========== FOCUS MODE ==========");
            System.out.println("1. Study Session History");
            System.out.println("2. Music Playlist");
            System.out.println("3. Course Recommendation");
            System.out.println("4. Back");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    SessionHistory.sessionMenu();
                    break;

                case 2:
                    MusicPlayer.musicMenu();
                    break;

                case 3:
                    CourseRecommendation.courseMenu();
                    break;

                case 4:
                    System.out.println("Returning to Dashboard...");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 4);
    }
}