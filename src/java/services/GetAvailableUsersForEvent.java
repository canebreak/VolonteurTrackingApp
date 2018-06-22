package services;

import db.DB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;
import models.User;

public class GetAvailableUsersForEvent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String eventId = request.getParameter("eventId");
        System.out.println(eventId);
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();
        try {
            con = DB.getConnection();
            stmt = con.createStatement();

            String query = "SELECT\n"
                    + "    u.id,\n"
                    + "    u.name,\n"
                    + "    u.birthday\n"
                    + "FROM\n"
                    + "    USER u\n"
                    + "LEFT JOIN user_event_xref xref ON\n"
                    + "    u.id = xref.user_id\n"
                    + "WHERE NOT\n"
                    + "    u.id IN(\n"
                    + "    SELECT\n"
                    + "        x.user_id\n"
                    + "    FROM\n"
                    + "        user_event_xref X\n"
                    + "    WHERE\n"
                    + "        X.event_id = " + eventId;

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setBirthday(rs.getDate("birthday"));
                user.setName(rs.getString("name"));

                userList.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GetAvailableUsersForEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        String json = new Gson().toJson(userList);
        
         response.setContentType("application/json");
         response.setCharacterEncoding("UTF-8");
         response.getWriter().write(json);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
