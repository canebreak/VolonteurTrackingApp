package rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

public class UsersRowMapper {

    public static List<User> mapData(ResultSet rs) {

        List<User> users = new ArrayList<>();
        User user = null;
        try {
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("last_name"));
                user.setBirthday(rs.getDate("birthday"));
                user.setStartYear(rs.getInt("start_year"));
                user.setUsername(rs.getString("username"));
                user.setTotalHours(rs.getFloat("total_hours"));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRowMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
}
