public  class SeriesModel {
    //decleration of varibales for the program
    public int seriesId;
    public String seriesName;
    public int seriesAgeRestriction;
    public int NumberOfEpisodes;

//here we are setting constructors
    public SeriesModel(int seriesId, String seriesName, int seriesAgeRestriction, int NumberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAgeRestriction = seriesAgeRestriction;
        this.NumberOfEpisodes = NumberOfEpisodes;

    }
//getters and setters that will be used in te program to set and update data through out
    public int getSeriesId() {
        return seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public int getSeriesAgeRestriction() {
        return seriesAgeRestriction;
    }

    public int geNumberOfEpisodes() {
        return NumberOfEpisodes;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        NumberOfEpisodes = numberOfEpisodes;
    }

    public void setSeriesAgeRestriction(int seriesAgeRestriction) {
        this.seriesAgeRestriction = seriesAgeRestriction;
    }

//method responsible for displaying report
    //the method is called in the child clas
    public String SeriesReport() {
        return "SERIES ID: " + seriesId +"\n"+
                "\nSERIES NAME: " + seriesName +"\n"+
                "\nSERIES AGE RESTRICTION: " + seriesAgeRestriction +"\n"+
                "\nNUMBER OF EPISODES: " + NumberOfEpisodes +"\n";

    }}
