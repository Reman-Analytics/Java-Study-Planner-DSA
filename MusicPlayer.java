import java.util.Scanner;

public class MusicPlayer {

    // Nested Class
    static class MusicTrack {
        int trackID;
        String trackName;
        MusicTrack next;

        public MusicTrack(int trackID, String trackName) {
            this.trackID = trackID;
            this.trackName = trackName;
            this.next = null;
        }
    }

    static MusicTrack head = null;
    static MusicTrack current = null;


    public static void musicMenu() {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n========== MUSIC PLAYER ==========");
            System.out.println("\nCRUD OPERATIONS");
            System.out.println("1. Add Music Track");
            System.out.println("2. View All Tracks");
            System.out.println("3. Update Track Name");
            System.out.println("4. Delete Track");

            System.out.println("\nCIRCULAR LINKED LIST OPERATIONS");
            System.out.println("5. Play Next Track");
            System.out.println("6. Display Circular Playlist");
            System.out.println("7. Back");

            System.out.print("\nEnter Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addTrack(sc);
                    break;

                case 2:
                    viewAllTracks();
                    break;

                case 3:
                    updateTrack(sc);
                    break;

                case 4:
                    deleteTrack(sc);
                    break;

                case 5:
                    playNextTrack();
                    break;

                case 6:
                    displayCircularPlaylist();
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
    public static void addTrack(Scanner sc) {

        System.out.print("Enter Track ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Track Name: ");
        String name = sc.nextLine();

        MusicTrack newTrack = new MusicTrack(id, name);

        // First Track
        if (head == null) {
            head = newTrack;
            head.next = head;
            current = head;
        }

        // Add at End
        else {

            MusicTrack temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newTrack;
            newTrack.next = head;
        }

        System.out.println("Track Added Successfully!");
    }


    // READ
    public static void viewAllTracks() {

        if (head == null) {
            System.out.println("Playlist is Empty.");
            return;
        }

        MusicTrack temp = head;

        System.out.println("\nMusic Tracks:");

        do {

            System.out.println("----------------------");
            System.out.println("Track ID   : " + temp.trackID);
            System.out.println("Track Name : " + temp.trackName);

            temp = temp.next;

        } while (temp != head);
    }


    // UPDATE
    public static void updateTrack(Scanner sc) {

        if (head == null) {
            System.out.println("Playlist is Empty.");
            return;
        }

        System.out.print("Enter Track ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        MusicTrack temp = head;

        do {

            if (temp.trackID == id) {

                System.out.print("Enter New Track Name: ");
                temp.trackName = sc.nextLine();

                System.out.println("Track Updated Successfully!");
                return;
            }

            temp = temp.next;

        } while (temp != head);

        System.out.println("Track Not Found.");
    }


    // DELETE
    public static void deleteTrack(Scanner sc) {

        if (head == null) {
            System.out.println("Playlist is Empty.");
            return;
        }

        System.out.print("Enter Track ID to Delete: ");
        int id = sc.nextInt();

        // Delete Head Node
        if (head.trackID == id) {

            // Only One Track
            if (head.next == head) {
                head = null;
                current = null;
            }

            else {

                MusicTrack temp = head;

                while (temp.next != head) {
                    temp = temp.next;
                }

                temp.next = head.next;
                head = head.next;
                current = head;
            }

            System.out.println("Track Deleted Successfully!");
            return;
        }

        // Delete Other Nodes
        MusicTrack prev = head;
        MusicTrack temp = head.next;

        while (temp != head) {

            if (temp.trackID == id) {

                prev.next = temp.next;
                System.out.println("Track Deleted Successfully!");
                return;
            }

            prev = temp;
            temp = temp.next;
        }

        System.out.println("Track Not Found.");
    }


    // CIRCULAR LINKED LIST OPERATION
    public static void playNextTrack() {

        if (current == null) {
            System.out.println("Playlist is Empty.");
            return;
        }

        current = current.next;

        System.out.println("\nNow Playing:");
        System.out.println(current.trackName);
    }


    // CIRCULAR TRAVERSAL
    public static void displayCircularPlaylist() {

        if (head == null) {
            System.out.println("Playlist is Empty.");
            return;
        }

        System.out.println("\nCircular Playlist:");

        MusicTrack temp = head;

        do {

            System.out.println(temp.trackName);
            temp = temp.next;

        } while (temp != head);

        System.out.println("\nBack to First Track!");
    }
}