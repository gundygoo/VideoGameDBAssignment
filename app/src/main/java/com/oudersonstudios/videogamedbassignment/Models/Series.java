package com.oudersonstudios.videogamedbassignment.Models;

/**
 * Created by Erik on 4/23/2017.
 */

public class Series {
    private String name;
    private String numberOfGames;
    private String yearStarted;

    public Series(String name, String numberOfGames, String yearStarted) {
        this.name = name;
        this.numberOfGames = numberOfGames;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    public String getNumberOfGames() {
        return numberOfGames;
    }

    public String getYearStarted() {
        return yearStarted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfGames(String numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public void setYearStarted(String yearStarted) {
        this.yearStarted = yearStarted;
    }
}
