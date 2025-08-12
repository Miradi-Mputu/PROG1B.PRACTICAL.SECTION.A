import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int userInput;
        int seriesId = 0;
        String seriesName = "";
        int seriesAgeRestriction = 0;
        int NumberOfEpisodes = 0;
        String streamingService = "";

        Series series = new Series( seriesId, seriesName, seriesAgeRestriction, NumberOfEpisodes, streamingService);

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.println("TV SERIES - 2025");
        System.out.println("-------------------------------------");
        System.out.println("Enter (1) to launch menu or any other key to exit");

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

            int choice = 0;
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
                series.captureSeries();
            } else if (choice == 2) {
                series.SearchSeries();
            } else if (choice == 3) {
                series.UpdateSeries();
            } else if (choice == 4) {
                series.DeleteSeries();
            } else if (choice == 5) {
                series.printSeriesReport();
            } else if (choice == 6) {
                series.exitApplication();
            } else {
                System.out.println("Invalid option. Please choose a number from 1 to 6.");
            }
        }
    }}