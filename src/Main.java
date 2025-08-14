import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //delceration
        int userInput;
        int seriesId = 0;
        String seriesName = "";
        int seriesAgeRestriction = 0;
        int NumberOfEpisodes = 0;

        //calling the method as an obeject to be used in the main class
        Series series = new Series( seriesId, seriesName, seriesAgeRestriction, NumberOfEpisodes);

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.println("TV SERIES - 2025");
        System.out.println("-------------------------------------");
        System.out.println("Enter (1) to launch menu or any other key to exit");
//condtion given to the user in order to make the code run
        if (scanner.hasNextInt()) {
            userInput = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Exiting application.");
            scanner.close();
            return;
        }

        if (userInput != 1) {
            System.out.println("Exiting application.");
            scanner.close();
            return;
        }

        //whole the code is still running/while the user has meet the rcondition they will be given these options
        while (true) {
            System.out.println("\n-------------------------------------");
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new series");
            System.out.println("(2) Search for a series");
            System.out.println("(3) Update a series");
            System.out.println("(4) Delete a series");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application");
            System.out.println("-------------------------------------");
//the code will only accept the following inputs
            int choice ;
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a number from the menu.");
                scanner.nextLine();
                continue;
            }

            if (choice == 1) {
                series.captureANewSeries();
            } else if (choice == 2) {
                series.searchSeries();
            } else if (choice == 3) {
                series.updateSeries();
            } else if (choice == 4) {
                series.deleteSeries();
            } else if (choice == 5) {
                series.seriesReport();
            } else if (choice == 6) {
                series.exitApp();
            } else {
                System.out.println("Invalid option. Please choose a number from 1 to 6.");
            }
        }
    }}