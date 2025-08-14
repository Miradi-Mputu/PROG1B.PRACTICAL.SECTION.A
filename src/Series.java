import java.util.ArrayList;
import java.util.Scanner;
public class Series extends SeriesModel {

    Scanner scanner = new Scanner(System.in);
    //decleration of arraylist
    ArrayList<SeriesModel> seriesList = new ArrayList<>();
//calling of constructors from the super class
    public Series(int seriesId, String seriesName, int seriesAgeRestriction, int NumberOfEpisodes) {
        super(seriesId, seriesName, seriesAgeRestriction, NumberOfEpisodes);
    }

    public void captureANewSeries() {
        //this is the body that takes in the users details
        SeriesModel seriesModel = new SeriesModel(seriesId, seriesName, seriesAgeRestriction, NumberOfEpisodes);

        System.out.println("Capture a new series" +
                "please follow the next commands:");
//everytime the user enters the details the code sets it with its corresponding variable
        System.out.println("Enter the series id:");
        seriesId = scanner.nextInt();
        seriesModel.setSeriesId(seriesId);

        System.out.println("Enter the series name:");
        seriesName = scanner.next();
        seriesModel.setSeriesName(seriesName);

        System.out.println("Enter the series age restrictions:");
        seriesAgeRestriction = scanner.nextInt();
        seriesModel.setSeriesAgeRestriction(seriesAgeRestriction);
        while (seriesAgeRestriction < 2 || seriesAgeRestriction > 18) {
            System.out.println("You have entered a incorrect series age !!!" +
                    "Please re-enter the series age");
            seriesAgeRestriction = scanner.nextInt();
            System.out.print("Enter the series age restrictions:");
            seriesAgeRestriction = scanner.nextInt();
        }
        System.out.println("Enter the number of episodes for " + seriesModel.getSeriesName() + ":");
        NumberOfEpisodes = scanner.nextInt();
        seriesModel.setNumberOfEpisodes(NumberOfEpisodes);

//here the code is storing all the data recived into the array list using the id as a primary key
        seriesList.add(seriesModel);
        System.out.print("Series successfully captured !!!");
    }


    public void searchSeries() {
        //this body of code runs throught the array comparing the id the user gave to the ids it has in the array
        //if it finds an id that matchs it will pull out the details under the specfic id
        SeriesModel i = null;
        System.out.print("Enter the series id to search: ");
        if (scanner.hasNextInt()) {
            seriesId = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Invalid input. Please enter a valid number for the series ID.");
            scanner.nextLine();
        }
        //here it is now searching the arraylist
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId() == seriesId) {
                i = series;
            }
        }
        //if it finds the match it should pull out the details under the specfic id list
        if (i != null) {
            System.out.println(i.SeriesReport());
        } else {
            System.out.println("Series with Series ID: " + seriesId + " was not found!");
        }

    }

    public void updateSeries() {
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
        scanner.nextLine();

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

            System.out.print("Enter the new number of episodes (" + seriesToUpdate.geNumberOfEpisodes() + "): ");
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
    }

    public void deleteSeries() {
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

    }

    public void seriesReport() {
        //this code is responsible for the displaying of all the details in the arraylist
        for (int i = 0; i < seriesList.size(); i++) {
            SeriesModel seriesModel = seriesList.get(i);

            System.out.print("Series ID:\n " +seriesModel.getSeriesId());
            System.out.println("Series name:\n"+ seriesModel.getSeriesName());
            System.out.println("Series age:\n"+seriesModel.getSeriesAgeRestriction());
            System.out.println("Number of episodes:\n"+seriesModel.geNumberOfEpisodes());
        }
    }
    public void exitApp(){
        System.out.println("Thank you for using the application");
        scanner.close();
    }
}