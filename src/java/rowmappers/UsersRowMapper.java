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

        List<User> userList = new ArrayList<>();

        try {
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("last_name"));
                user.setBirthday(rs.getDate("birthday"));
                user.setTotalHours(rs.getFloat("total_hours"));
                user.setStartYear(rs.getInt("start_year"));
                user.setNickName(rs.getString("nickname"));
                userList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersRowMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
    }
}
