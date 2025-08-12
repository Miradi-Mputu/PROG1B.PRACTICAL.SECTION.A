public class SeriesModel {
    public int seriesId;
    public String seriesName;
    public int seriesAgeRestriction;
    public int NumberOfEpisodes;
    public String streamingService;

    public SeriesModel(int seriesId, String seriesName, int seriesAgeRestriction, int NumberOfEpisodes, String streamingService) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAgeRestriction = seriesAgeRestriction;
        this.NumberOfEpisodes = NumberOfEpisodes;
        this.streamingService = streamingService;
    }

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

    public String getStreamingService() {
        return streamingService;
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

    public void setStreamingService(String streamingService) {
        this.streamingService = streamingService;
    }

    public String SeriesReport() {
        return "SERIES ID: " + seriesId +
                "\nSERIES NAME: " + seriesName +
                "\nSERIES AGE RESTRICTION: " + seriesAgeRestriction +
                "\nNUMBER OF EPISODES: " + NumberOfEpisodes +
                "\nSTREAMING SERVICE: " + streamingService + "\n";

    }}
