package com.oudersonstudios.videogamedbassignment.Models;

/**
 * Created by Erik on 4/23/2017.
 */

public class VideoGame {
    private String name;
    private String publisher;
    private String releaseYear;
    private String genre;
    private String esrbRating;
    private String platform;
    private String seriesName;

    public VideoGame(String name, String publisher, String releaseYear, String genre, String esrbRating, String platform, String seriesName) {
        this.name = name;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.esrbRating = esrbRating;
        this.platform = platform;
        this.seriesName = seriesName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public String getPlatform() {
        return platform;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }




}
