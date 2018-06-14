/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rowmappers;

import java.sql.ResultSet;
import models.User;

/**
 *
 * @author Blagoje
 */
public class UserRowMapper {
    
    public static User mapData(ResultSet rs)
    {
        User user = new User();
        
        
        return user;
    }
    
}
