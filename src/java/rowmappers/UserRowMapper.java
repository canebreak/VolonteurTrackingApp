/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

/**
 *
 * @author Blagoje
 */
public class UserRowMapper {

    public static User mapData(ResultSet rs) {
        User user = new User();

        try {
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName("name");
                user.setLastName(rs.getString("last_name"));
                user.setBirthday(rs.getDate("bithday"));
                user.setTotalHours(rs.getInt("total_hours"));
                user.setStartYear(rs.getInt("start_year"));
                user.setIsAdmin(rs.getInt("is_admin"));
                user.setNickName(rs.getString("nickname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRowMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

}
