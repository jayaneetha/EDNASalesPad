package com.colombosoft.ednasalespad.model;

/**
 * Created by DragonSlayer on 11/4/2015.
 */
public class GeoCordinates {

    private double Lat;
    private double Long;

    public GeoCordinates() {
    }

    public GeoCordinates(double aLong, double lat) {
        Long = aLong;
        Lat = lat;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(double lat) {
        Lat = lat;
    }

    public double getLong() {
        return Long;
    }

    public void setLong(double aLong) {
        Long = aLong;
    }
}
