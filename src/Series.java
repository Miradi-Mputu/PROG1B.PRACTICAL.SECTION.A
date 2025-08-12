import java.util.ArrayList;
import java.util.Scanner;

public class Series extends SeriesModel{
    public Series(int seriesId, String seriesName, int seriesAgeRestriction, int NumberOfEpisodes, String streamingService) {
        super(seriesId, seriesName, seriesAgeRestriction, NumberOfEpisodes, streamingService);
    }
    Scanner scanner= new Scanner(System.in);
    public static ArrayList<Series> seriesList = new ArrayList<>();

    public String captureSeries(){
        System.out.println("-------------------------------------");
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("-------------------------------------");

        System.out.print("Enter the series id: ");
        seriesId = scanner.nextInt();


        System.out.print("Enter the series name: ");
        seriesName = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Enter the series age restriction: ");
        seriesAgeRestriction = scanner.nextInt();
        if (seriesAgeRestriction < 2 || seriesAgeRestriction > 18) {
            System.out.println("Age meets the restriction");
        } else {
            System.out.println("Invalid input. Please enter a valid number for the age restriction.");
            scanner.nextLine();
        }

        System.out.print("Enter the number of episodes: ");
        NumberOfEpisodes = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the streaming service: ");
        streamingService = scanner.nextLine();

        Series newSeries = new Series(seriesId, seriesName, seriesAgeRestriction, NumberOfEpisodes, streamingService);
        seriesList.add(newSeries);
        System.out.println("Series processed successfully!!!");
        return "";
    }

    public void SearchSeries(){

        SeriesModel i = null;
        System.out.print("Enter the series id to search: ");
        if (scanner.hasNextInt()) {
            seriesId = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Invalid input. Please enter a valid number for the series ID.");
            scanner.nextLine();
        }
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId() == seriesId) {
                i = series;
            }
        }
        if (i != null) {
            System.out.println(i.SeriesReport());
        } else {
            System.out.println("Series with Series ID: " + seriesId + " was not found!");
        }
    }

    public String UpdateSeries(){
        // Decleration of new variables for the updating details
        int seriesId =0 ;
        SeriesModel seriesToUpdate = null;
        String newSeriesName;
        int newAgeRestriction;
        int newNumberOfEpisodes;

        System.out.print("Enter the series id to update: ");
        //scanner.hasNextInt() :If the user has entered a vaule then the next stage of the code will be activated
        if (scanner.hasNextInt()) {
            seriesId = scanner.nextInt();
        } else {
            System.out.println("Invalid input. Please enter a valid number for the series ID.");
        }
        //This body of code loops through the array list to see if the ID given matchs any of the ids in the arraylist
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId() == seriesId) {
                seriesToUpdate = series;
            }
        }
        //In this body of code the user inserts the new details , the program goes and gets the details that need to be updated
        if (seriesToUpdate != null) {
            System.out.print("Enter the new series name (" + seriesToUpdate.getSeriesName() + "): ");
            newSeriesName = scanner.nextLine();
            //here the program sets the new details
            seriesToUpdate.setSeriesName(newSeriesName);

            System.out.print("Enter the new age restriction (" + seriesToUpdate.getSeriesAgeRestriction() + "): ");
            if (scanner.hasNextInt()) {
                newAgeRestriction = scanner.nextInt();
                if (newAgeRestriction >= 2 && newAgeRestriction <= 18) {
                    seriesToUpdate.setSeriesAgeRestriction(newAgeRestriction);
                } else {
                    System.out.println("You have entered an incorrect series age restriction!!!");
                }
            } else {
                System.out.println("Invalid input. Update failed.");
            }
            System.out.print("Enter the new number of episodes: ");
            if (scanner.hasNextInt()) {
                newNumberOfEpisodes = scanner.nextInt();
                seriesToUpdate.setNumberOfEpisodes(newNumberOfEpisodes);
            } else {
                System.out.println("Invalid input. Update failed.");
            }
            System.out.println("Series with ID: " + seriesId + " has been updated successfully!");
        } else {
            System.out.println("Series with Series ID: " + seriesId + " was not found!");
        }
        return "";
    }

    public String DeleteSeries(){
        //decleration of the variables that will be used in this method only
        SeriesModel seriesToDelete = null;
        String confirmation;

        //here the user will input the id so that it can be searched for
        System.out.print("Enter the series id to delete: ");
        if (scanner.hasNextInt()) {
            seriesId = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Invalid input. Please enter a valid number for the series ID.");
            scanner.nextLine();
        }
        //the loop runs through the array to chech if the id given is found within the array list
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId() == seriesId) {
                seriesToDelete = series;
            }
        }
        //This body of code gives the user an option
        //if the user gives the command that the code follows(that being the letter "y") the code will activate and delete the series info
        if (seriesToDelete != null) {
            System.out.print("Are you sure you want to delete Series ID: " + seriesId + " from the system? Yes (y) to delete: ");
            confirmation = scanner.nextLine();

            //if the user inputs the letter "y" then the code will activate
            if (confirmation.equalsIgnoreCase("y")) {
                seriesList.remove(seriesToDelete);
                System.out.println("Series with Series ID: " + seriesId + " WAS deleted!");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Series with Series ID: " + seriesId + " was not found!");
        }
        return "";
    }


    public void printSeriesReport() {
        //this body is responsible for printing the all the details that are stored in the array list in its respective order
        System.out.println("-------------------------------------");
        System.out.println("SERIES REPORT - 2025");
        System.out.println("-------------------------------------");
        if (seriesList.isEmpty()) {
            System.out.println("No series data available to display.");
        } else {
            for (SeriesModel series : seriesList) {
                System.out.println("-------------------------------------");
                System.out.println(series.SeriesReport());
            }
        }
    }

    public void exitApplication() {
        //when the user selects the method that activates this code which closes the program
        System.out.println("Exiting the application. Goodbye!");
        scanner.close();
    }
}
