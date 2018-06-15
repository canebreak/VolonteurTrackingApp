package rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Event;

public class EventRowMapper {

    public static Event mapData(ResultSet rs) {

        Event event = null;
        try {
            if (rs.next()) {
                event = new Event();
                event.setId(rs.getInt("id"));
                event.setName(rs.getString("name"));
                event.setDate(rs.getDate("date"));
                event.setStartTime(rs.getString("startTime"));
                event.setVolonteurNumber(rs.getInt("volonteur_number"));
                event.setEndTime(rs.getString("endTime"));
                event.setDurationInHours(rs.getFloat("hours_duration"));
                event.setPlace(rs.getString("place"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventRowMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }
}
