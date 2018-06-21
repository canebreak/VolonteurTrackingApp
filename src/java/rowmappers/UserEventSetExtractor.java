package rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Event;
import models.UserEvents;

public class UserEventSetExtractor {

    public static UserEvents mapData(ResultSet rs) {
        UserEvents userEvents = null;
        float hours = 0;
        try {
            while (rs.next()) {
                if (userEvents == null) {
                    userEvents = new UserEvents();

                    userEvents.setId(rs.getInt("id"));
                    userEvents.setName(rs.getString("user_name"));
                    userEvents.setLastName(rs.getString("last_name"));
                    userEvents.setBirthday(rs.getDate("birthday"));
                    userEvents.setStartYear(rs.getInt("start_year"));
                    userEvents.setNickName(rs.getString("nickname"));
                    userEvents.setEvents(new ArrayList<>());
                }
                Event event = new Event();
                event.setName(rs.getString("event_name"));
                event.setDate(rs.getDate("date"));
                event.setStartTime(rs.getString("start_time"));
                event.setEndTime(rs.getString("end_time"));
                event.setDurationInHours(rs.getFloat("hours"));
                hours += rs.getFloat("hours");
                System.out.println("hours: " + rs.getFloat("hours"));
                event.setPlace(rs.getString("place"));

                userEvents.getEvents().add(event);
            }
            if (userEvents == null) {
                return null;
            } else {
                userEvents.setTotalHours(hours);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserEventSetExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userEvents;
    }

}
