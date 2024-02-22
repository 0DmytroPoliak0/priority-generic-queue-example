
import java.util.InputMismatchException;
import java.util.Scanner;

// PrintManager class to handle print scheduling
public class PrintManager {
    private PriorityGenericQueue<PrintingJob> printQueue;

    // Constructor
    public PrintManager() {
        printQueue = new PriorityGenericQueue<>();
    }

    // Method to add a new printing job
    public void addPrintingJob(int jobID, String user, int urgency, int numberOfPages) {
        printQueue.enqueue(new PrintingJob(jobID, user, urgency, numberOfPages), urgency);
    }

    // Method to simulate printing job
    public void simulatePrintingJob() {
        if (!printQueue.isEmpty()) {
            PrintingJob job = printQueue.dequeue();
            System.out.println("Printing Job ID: " + job.getJobID());
            System.out.println("Number of pages to be printed: " + job.getNumberOfPages());
        } else {
            System.out.println("Error: The printing list is empty.");
        }
    }

    // Main method
    public static void main(String[] args) {
        testcode.PrintManager printManager = new testcode.PrintManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a new printing job");
            System.out.println("2. Simulate a printing job");
            System.out.println("3. Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter JobID:");
                    int jobID = scanner.nextInt();
                    System.out.println("Enter User (Admin/Non-admin):");
                    String user = scanner.next();
                    System.out.println("Enter Urgency (1-10):");
                    int urgency = scanner.nextInt();
                    System.out.println("Enter Number of Pages:");
                    int numberOfPages = scanner.nextInt();
                    printManager.addPrintingJob(jobID, user, urgency, numberOfPages);
                    System.out.println("Printing job added successfully.");
                    break;
                case 2:
                    printManager.simulatePrintingJob();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
