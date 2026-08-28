import java.util.Scanner;


class PlannerNode {
    String taskName;
    int startTime; 
    int endTime;
    PlannerNode next;

    public PlannerNode(String taskName, int startTime, int endTime) {
        this.taskName = taskName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.next = null;
    }
}

public class Planner {
    private PlannerNode head = null;
    private Scanner input = new Scanner(System.in);

   
    public void showPlanner() {
        int choice;
        do {
            System.out.println("\n==============================================");
            System.out.println("\t\t\tPLANNER");
            System.out.println("\t\t---------------------");
            System.out.println("1. Add Task");
            System.out.println("2. Display All Planned Tasks");
            System.out.println("3. Sort Planner By Time (Ascending)");
            System.out.println("4. Detect Schedule Conflict (Overlap)");
            System.out.println("5. Reverse Planner Layout");
            System.out.println("6. Back to Dashboard");
            System.out.println("----------------------------------------------");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    displayPlanner();
                    break;
                case 3:
                    sortPlannerByTime();
                    break;
                case 4:
                    detectScheduleConflict();
                    break;
                case 5:
                    reversePlanner();
                    break;
                case 6:
                    System.out.println("\nReturning to Dashboard...");
                    return; 
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (true);
    }

    
    private void addTask() {
        System.out.print("Enter Task/Lecture Name: ");
        String name = input.nextLine();
        System.out.print("Enter Start Time (Format 24Hr, e.g. 0900 or 1430): ");
        int start = input.nextInt();
        System.out.print("Enter End Time (Format 24Hr, e.g. 1030 or 1600): ");
        int end = input.nextInt();

        PlannerNode newNode = new PlannerNode(name, start, end);
        if (head == null) {
            head = newNode;
        } else {
            PlannerNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Task added successfully to the Planner!");
    }

    // Helper: Display Linked List using While Loop
    private void displayPlanner() {
        if (head == null) {
            System.out.println("\n[Planner is Empty! Add some tasks first.]");
            return;
        }
        System.out.println("\n--- Current Study Planner ---");
        PlannerNode temp = head;
        while (temp != null) {
            System.out.println("Task: " + temp.taskName + " | Time: " + temp.startTime + " to " + temp.endTime);
            temp = temp.next;
        }
    }

    // Method 1: Sort Planner By Time 
    public void sortPlannerByTime() {
        if (head == null || head.next == null) {
            System.out.println("Planner is already sorted or empty!");
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            PlannerNode current = head;
            while (current.next != null) {
                if (current.startTime > current.next.startTime) {
                    // Swap Data
                    int tempStart = current.startTime;
                    int tempEnd = current.endTime;
                    String tempName = current.taskName;

                    current.startTime = current.next.startTime;
                    current.endTime = current.next.endTime;
                    current.taskName = current.next.taskName;

                    current.next.startTime = tempStart;
                    current.next.endTime = tempEnd;
                    current.next.taskName = tempName;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        System.out.println("\n[Planner has been successfully sorted chronologically!]");
        displayPlanner();
    }

    
    public void detectScheduleConflict() {
        if (head == null || head.next == null) {
            System.out.println("\n[Not enough tasks to detect conflict.]");
            return;
        }

        // 1st step is to sort chronologically for easy collision scanning
        sortPlannerByTime();

        PlannerNode current = head;
        boolean conflictFound = false;

        System.out.println("\n--- Checking for Time Overlaps ---");
        while (current != null && current.next != null) {
            // If the start time of the next class is before the end of current class
            if (current.next.startTime < current.endTime) {
                System.out.println("⚠️ CONFLICT DETECTED: \"" + current.taskName + "\" overlaps with \"" + current.next.taskName + "\".");
                conflictFound = true;
            }
            current = current.next;
        }

        if (!conflictFound) {
            System.out.println("Great! No schedule conflicts found.");
        }
    }

    // Method 3: Reverse Planner 
    public void reversePlanner() {
        if (head == null || head.next == null) {
            System.out.println("\n[Planner is already reversed or empty!]");
            return;
        }

        PlannerNode prev = null;
        PlannerNode current = head;
        PlannerNode nextNode = null;

        while (current != null) {
            nextNode = current.next; // Keep track of next
            current.next = prev;     // Reverse current pointer
            prev = current;          // Move pointers forward
            current = nextNode;
        }
        head = prev; // Update new head

        System.out.println("\n[Planner layout has been successfully reversed!]");
        displayPlanner();
    }
}