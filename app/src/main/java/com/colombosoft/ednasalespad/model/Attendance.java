package com.colombosoft.ednasalespad.model;

import java.util.Date;

/**
 * Created by DragonSlayer on 11/1/2015.
 */
public class Attendance {

    private Location Location;
    private String DateAndTime;
    private int Type;
    private String UserId;

    public Location getLocation() {
        return Location;
    }

    public void setLocation(Location location) {
        Location = location;
    }

    public String getDateAndTime() {
        return DateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        DateAndTime = dateAndTime;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
