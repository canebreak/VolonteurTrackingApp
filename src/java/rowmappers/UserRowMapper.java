package rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

public class UserRowMapper {

    public static User mapData(ResultSet rs) {

        User user = null;
        try {
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("last_name"));
                user.setBirthday(rs.getDate("birthday"));
                user.setStartYear(rs.getInt("start_year"));
                user.setPassword(rs.getString("password"));
                user.setIsAdmin(rs.getInt("is_admin"));
                user.setTotalHours(rs.getFloat("total_hours"));
                user.setUsername(rs.getString("username"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRowMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
