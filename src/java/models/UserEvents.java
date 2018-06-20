
package models;

import java.util.List;


public class UserEvents extends User {
    List<Event> events;
    
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
    
    
}
