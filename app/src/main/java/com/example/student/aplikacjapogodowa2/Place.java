package com.example.student.aplikacjapogodowa2;

/**
 * Created by student on 2018-01-03.
 */

public class Place {
    private String cityName;
    private int temperature;
    private String information;

    public String getPlaceName() {
        return cityName;
    }

    public void setPlaceName(String cityName) {
        this.cityName = cityName;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Place(String cityName,  String information) {
        this.cityName = cityName;

        this.information = information;
    }
}
