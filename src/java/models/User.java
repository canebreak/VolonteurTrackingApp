package models;

import java.util.Date;

public class User {

    private int id;
    private String name, lastName, username;
    private Date birthday;
    private float totalHours;
    private int startYear;
    private String password;
    private int isAdmin;

    public User() {
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

 

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public float getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(float totalHours) {
        this.totalHours = totalHours;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

 

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", lastName=" +
                lastName + ", username=" + username + ", birthday=" + birthday 
                + ", totalNumber=" + totalHours + ", startYear=" + startYear
                + ", password=" + password + ",}";
    }

}
