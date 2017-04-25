package com.oudersonstudios.videogamedbassignment.Models;

/**
 * Created by Erik on 4/23/2017.
 */

public class Platform {
    private String name;
    private String developer;
    private String yearReleased;

    public Platform(String name, String developer, String yearReleased) {
        this.name = name;
        this.developer = developer;
        this.yearReleased = yearReleased;
    }

    public String getName() {
        return name;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getYearReleased() {
        return yearReleased;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setYearReleased(String yearReleased) {
        this.yearReleased = yearReleased;
    }
}
