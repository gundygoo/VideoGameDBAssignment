package com.oudersonstudios.videogamedbassignment.Models;

/**
 * Created by Erik on 4/23/2017.
 */

public class Publisher {
    private String name;
    private String location;
    private String yearEstablished;

    public Publisher(String name, String location, String yearEstablished) {
        this.name = name;
        this.location = location;
        this.yearEstablished = yearEstablished;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getYearEstablished() {
        return yearEstablished;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setYearEstablished(String yearEstablished) {
        this.yearEstablished = yearEstablished;
    }
}
