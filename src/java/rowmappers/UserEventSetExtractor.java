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

        try {
            while (rs.next()) {
                if (userEvents == null) {
                    userEvents = new UserEvents();

                    userEvents.setId(rs.getInt("id"));
                    userEvents.setName(rs.getString("user_name"));
                    userEvents.setLastName(rs.getString("last_name"));
                    userEvents.setBirthday(rs.getDate("birthday"));
                    userEvents.setTotalHours(rs.getInt("total_hours"));
                    userEvents.setStartYear(rs.getInt("start_year"));
                    userEvents.setNickName(rs.getString("nickname"));
                    userEvents.setEvents(new ArrayList<Event>());
                }
                Event event = new Event();
                event.setName(rs.getString("event_name"));
                event.setDate(rs.getDate("date"));
                event.setStartTime(rs.getString("start_time"));
                event.setEndTime(rs.getString("end_time"));
                event.setDurationInHours(rs.getFloat("hours_duration"));
                event.setPlace(rs.getString("place"));

                userEvents.getEvents().add(event);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserEventSetExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userEvents;
    }

}
