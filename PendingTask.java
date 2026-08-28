import java.util.Scanner;

public class PendingTask {

    private String[] taskName = new String[20];
    private int[] deadline = new int[20];
    private int[] priority = new int[20];

    private int count = 0;

    Scanner input = new Scanner(System.in);

    public void showPendingTask() {

        int choice;

        do {

            System.out.println("\n==============================================");
            System.out.println("\t\tPENDING TASKS");
            System.out.println("\t\t-------------");
            System.out.println("1. Add Task");
            System.out.println("2. Display All Tasks");
            System.out.println("3. Sort Tasks By Deadline");
            System.out.println("4. Process Highest Priority Task");
            System.out.println("5. Back to Dashboard");
            System.out.println("----------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    addTask();
                    break;

                case 2:
                    displayTasks();
                    break;

                case 3:
                    sortTasksByDeadline();
                    break;

                case 4:
                    showHighPriorityTasks();
                    break;

                case 5:
                    System.out.println("\nReturning to Dashboard...");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (true);
    }

    // Add Task
    public void addTask() {

        if (count == 20) {

            System.out.println("\nTask List is Full!");
            return;
        }

        System.out.print("Enter Task Name: ");
        taskName[count] = input.nextLine();

        System.out.print("Enter Deadline (Day of Month): ");
        deadline[count] = input.nextInt();

        System.out.print("Enter Priority (1-High, 2-Medium, 3-Low): ");
        priority[count] = input.nextInt();

        input.nextLine();

        count++;

        System.out.println("\nTask Added Successfully!");
    }

    // Display Tasks
    public void displayTasks() {

        if (count == 0) {

            System.out.println("\nNo Pending Tasks Found!");
            return;
        }

        System.out.println("\n========== Pending Tasks ==========");

        for (int i = 0; i < count; i++) {

            System.out.println("Task Name : " + taskName[i]);
            System.out.println("Deadline  : " + deadline[i]);

            if (priority[i] == 1)
                System.out.println("Priority  : High");
            else if (priority[i] == 2)
                System.out.println("Priority  : Medium");
            else
                System.out.println("Priority  : Low");

            System.out.println("--------------------------------");
        }
    }

    // Bubble Sort
    public void sortTasksByDeadline() {

        if (count == 0) {

            System.out.println("\nNo Pending Tasks Found!");
            return;
        }

        for (int i = 0; i < count - 1; i++) {

            for (int j = 0; j < count - i - 1; j++) {

                if (deadline[j] > deadline[j + 1]) {

                    // Swap Deadline
                    int tempDeadline = deadline[j];
                    deadline[j] = deadline[j + 1];
                    deadline[j + 1] = tempDeadline;

                    // Swap Task Name
                    String tempTask = taskName[j];
                    taskName[j] = taskName[j + 1];
                    taskName[j + 1] = tempTask;

                    // Swap Priority
                    int tempPriority = priority[j];
                    priority[j] = priority[j + 1];
                    priority[j + 1] = tempPriority;
                }
            }
        }

        System.out.println("\nTasks Sorted By Deadline Successfully!");
        displayTasks();
    }

    // Manual Priority Queue
    public void showHighPriorityTasks() {

        if (count == 0) {

            System.out.println("\nNo Pending Tasks Found!");
            return;
        }

        // Assume first task has highest priority
        int highest = 0;

        // Find highest priority task
        for (int i = 1; i < count; i++) {

            if (priority[i] < priority[highest]) {

                highest = i;
            }
        }

        System.out.println("\n========== Processing Highest Priority Task ==========");

        System.out.println("Task Name : " + taskName[highest]);
        System.out.println("Deadline  : " + deadline[highest]);

        if (priority[highest] == 1)
            System.out.println("Priority  : High");
        else if (priority[highest] == 2)
            System.out.println("Priority  : Medium");
        else
            System.out.println("Priority  : Low");

        System.out.println("--------------------------------");

        // Remove task by shifting left
        for (int i = highest; i < count - 1; i++) {

            taskName[i] = taskName[i + 1];
            deadline[i] = deadline[i + 1];
            priority[i] = priority[i + 1];
        }

        count--;

        System.out.println("Task Processed Successfully!");
    }
}