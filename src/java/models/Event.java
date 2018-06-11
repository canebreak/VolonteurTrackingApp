
package models;

import java.time.LocalDate;

public class Event {
    
    private int id;
    private String name;
    private LocalDate date;
    private String time;
    private int volonteurNumber;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

