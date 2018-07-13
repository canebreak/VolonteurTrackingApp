package models;

import java.sql.Date;

public class Event {

    private int id;
    private String name, place, startTime, endTime;
    private Date date;
    private float hoursDuration;
    private int volonteurNumber;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public float getDurationInHours() {
        return hoursDuration;
    }

    public void setDurationInHours(float durationInHours) {
        this.hoursDuration = durationInHours;
    }
    private int isDeleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getVolonteurNumber() {
        return volonteurNumber;
    }

    public void setVolonteurNumber(int volonteurNumber) {
        this.volonteurNumber = volonteurNumber;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

}
