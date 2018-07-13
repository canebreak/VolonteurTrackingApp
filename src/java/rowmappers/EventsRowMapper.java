
package rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Event;


public class EventsRowMapper {
    
    public static List<Event> mapData(ResultSet rs){
        List<Event> events = new ArrayList<>();
        
        
        try {
            while(rs.next()){
                Event event = new Event();
                event.setId(rs.getInt("id"));
                event.setName(rs.getString("name"));
                event.setDate(rs.getDate("date"));
                event.setStartTime(rs.getString("start_time"));
                event.setEndTime(rs.getString("end_time"));
                event.setPlace(rs.getString("place"));
                event.setDurationInHours(rs.getFloat("hours_duration"));
                
                events.add(event);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventsRowMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return events;
    }
}
