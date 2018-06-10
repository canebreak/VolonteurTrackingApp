package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jason Stevan
 */
public class DB {

    private static Connection myconnection;

    private DB() {
    }

    public static Connection getConnection() {

        if (myconnection == null) {
            
        
        {
            try {
                myconnection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/volonteur_tracking_app",
                        "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        }
        return myconnection;
    }
}