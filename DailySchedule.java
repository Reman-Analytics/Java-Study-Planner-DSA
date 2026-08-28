import java.util.Scanner;

public class DailySchedule {
    private String[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    private Scanner input = new Scanner(System.in);

    // Constructor setting custom size array queue
    public DailySchedule() {
        this.capacity = 10; // Max 10 dynamic active lectures tracking
        this.queue = new String[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Dynamic Dashboard for Daily Queue (Like Performance page)
    public void showDailySchedule() {
        int choice;
        do {
            System.out.println("\n==============================================");
            System.out.println("\t\tDAILY SCHEDULE ");
            System.out.println("\t\t----------------------");
            System.out.println("1. Add Upcoming Lecture");
            System.out.println("2. Display Current  List");
            System.out.println("3. Next Lecture ");
            System.out.println("4. Count Remaining Lectures");
            System.out.println("5. Back to Dashboard");
            System.out.println("----------------------------------------------");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    enqueueLecture();
                    break;
                case 2:
                    displayQueue();
                    break;
                case 3:
                    nextLecture();
                    break;
                case 4:
                    countRemainingLectures();
                    break;
                case 5:
                    System.out.println("\nReturning to Dashboard...");
                    return; 
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (true);
    }

   
    private void enqueueLecture() {
        if (size == capacity) {
            System.out.println("\n[Daily Schedule list is Full! Cannot add more lectures.]");
            return;
        }
        System.out.print("Enter Upcoming Lecture/Activity: ");
        String lecture = input.nextLine();

        
        rear = (rear + 1) % capacity;
        queue[rear] = lecture;
        size++;

        System.out.println("Successfully Added: \"" + lecture + "\"!");
    }

    // Display Queue Items
    private void displayQueue() {
        if (size == 0) {
            System.out.println("\n[No upcoming lectures in today's list.]");
            return;
        }
        System.out.println("\n--- Todays Lecture Lineup  ---");
        int tempFront = front;
        int count = 0;
        while (count < size) {
            System.out.println((count + 1) + ". " + queue[tempFront]);
            tempFront = (tempFront + 1) % capacity;
            count++;
        }
    }


    public void nextLecture() {
        if (size == 0) {
            System.out.println("\n🎉 Hurray! No more classes. Today's list is empty!");
            return;
        }

        // Accessing the queue front
        String currentLecture = queue[front];
        System.out.println("\n🔔 CURRENT ACTIVE LECTURE: \"" + currentLecture + "\"");
        
        
        front = (front + 1) % capacity;
        size--;

        System.out.println("[Status: Session complete. Shifted to the next slot.]");
    }

    // Method 5: Count Remaining Lectures 
    public void countRemainingLectures() {
        System.out.println("\n==============================================");
        System.out.println("Remaining Lectures to attend today: " + size);
        if (size > 0) {
            System.out.println("Next up in line is: \"" + queue[front] + "\"");
        }
        System.out.println("==============================================");
    }
}
    