import java.util.Scanner;

public class Performance {

    Scanner input = new Scanner(System.in);

    public void showPerformance() {

        int choice;

        do {

            System.out.println("\n==============================================");
            System.out.println("\t\tPERFORMANCE");
            System.out.println("\t\t-----------");
            System.out.println();

            System.out.println("1. Calculate CGPA");
            System.out.println("2. Weekly_hours");
            System.out.println("3. Recent Activities");
            System.out.println("4. Rank Subjects");
            System.out.println("5. Back to Dashboard");
          

            System.out.println("----------------------------------------------");
            System.out.print("Enter your choice : ");
            choice = input.nextInt();

            switch(choice)
            {

                case 1:
                    calculateCGPA();
                    break;

                case 2:
                    weekly_hours();
                    break;

                case 3:
                    show_Recent_Activities();
                    break;

               case 4:
                    Rank_Subjects();
                    break;


                case 5:

                    Dashboard d = new Dashboard();
                    d.showDashboard();
                    return;

              

                default:

                    System.out.println("\nInvalid Choice!");

               

            }

        } while(true);
    }

        //Calculate CGPA (Array)
        public void calculateCGPA() {

            System.out.println("\n========== Calculate CGPA ==========");
            System.out.print("Enter number of subjects: ");

            int n = input.nextInt();

            // Arrays to store GPA and Credit Hours
            double[] gpa = new double[n];
            int[] creditHours = new int[n];

            // Input values
            for (int i = 0; i < n; i++) {

                System.out.println("\nSubject " + (i + 1));
                System.out.print("Enter GPA: ");
                gpa[i] = input.nextDouble();

                System.out.print("Enter Credit Hours: ");
                creditHours[i] = input.nextInt();
            }

                double totalPoints = 0;
                int totalCredits = 0;

                // Calculate Total Points and Credits
                for (int i = 0; i < n; i++) {

                totalPoints += gpa[i] * creditHours[i];
                totalCredits += creditHours[i];

                }

                double cgpa = totalPoints / totalCredits;

                System.out.println("\n========== RESULT ==========");
                System.out.println("Total Credit Hours : " + totalCredits);
                System.out.printf("Calculated CGPA    : %.2f\n", cgpa);
        }// calculate CGPA




            //weekly hours using array 
            public void weekly_hours() {
                String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
                int[] hours = new int[7];

                System.out.println("\n===== Enter Weekly Study Hours =====");
    
            for (int i = 0; i < days.length; i++) {
                System.out.print("Enter hours for " + days[i] + ": ");
                hours[i] = input.nextInt();
            }

                 System.out.println("\n===== Weekly Study Hours =====");
    
                int totalHours = 0;
                for (int i = 0; i < days.length; i++) {
                     System.out.println(days[i] + " : " + hours[i] + " Hours");
                        totalHours += hours[i];
                }
    
            System.out.println("------------------------------");
            System.out.println("Total Hours Studied: " + totalHours + " Hours");
        }//weekly_hours (array)


        //stack
       public void show_Recent_Activities() {

            System.out.println("\n========== Recent Activities ==========");

            System.out.print("How many activities do you want to enter? ");
            int n = input.nextInt();
            input.nextLine(); // Buffer clear

            // Manual Stack
            String[] activities = new String[n];
            int top = -1;

            // Push Operation
            for (int i = 0; i < n; i++) {

                System.out.print("Enter Activity " + (i + 1) + ": ");
                String activity = input.nextLine();

                if (top < n - 1) {
                    top++;
                    activities[top] = activity;
                } else {
                    System.out.println("Stack Overflow!");
                }
    }

    // Display in LIFO Order (Top to Bottom)
    System.out.println("\nRecent Activities (Latest First):");

    while (top != -1) {
        System.out.println(activities[top]);
        top--;      // Pop Operation
    }
}

   


        //Rank_Subjects using bubble_Sort
        public void Rank_Subjects() {

            System.out.println("\n========== Subject Ranking ==========");
            System.out.print("Enter Total Number of Subjects: ");

            int n = input.nextInt();
            input.nextLine();

            String[] subjects = new String[n];
            int[] marks = new int[n];

            // User Input
            for (int i = 0; i < n; i++) {

                System.out.println("\nSubject " + (i + 1));

                System.out.print("Enter Subject Name: ");
                subjects[i] = input.nextLine();

                System.out.print("Enter Obtained Marks: ");
                marks[i] = input.nextInt();
                input.nextLine();
            }

             // Bubble Sort
            bubbleSort(subjects, marks);

            // Display Ranking
            System.out.println("\n========== Subject Ranking ==========");

            for (int i = 0; i < n; i++) {
                System.out.println("Rank " + (i + 1));
                System.out.println("Subject : " + subjects[i]);
                System.out.println("Marks   : " + marks[i]);
                System.out.println("---------------------------");
            }
        }
        public void bubbleSort(String[] subjects, int[] marks) {

            int n = marks.length;

            for (int i = 0; i < n - 1; i++) {

                for (int j = 0; j < n - i - 1; j++) {

                    if (marks[j] < marks[j + 1]) {

                        // Swap Marks
                        int tempMark = marks[j];
                        marks[j] = marks[j + 1];
                        marks[j + 1] = tempMark;

                        // Swap Subjects
                        String tempSubject = subjects[j];
                        subjects[j] = subjects[j + 1];
                        subjects[j + 1] = tempSubject;
                    }
                }
            }
        }//bubble sort
            
}//class