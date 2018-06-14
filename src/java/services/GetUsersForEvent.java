package services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import db.DB;
import java.sql.SQLException;
import models.User;

public class GetUsersForEvent extends HttpServlet {

    protected List<User> processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int eventId = Integer.parseInt(request.getParameter("eventId"));

        Connection con;
        Statement stmt;
        ResultSet rs;
        HttpSession session = request.getSession();

        List<User> userList = new ArrayList<User>();

        try {
            con = DB.getConnection();
            stmt = con.createStatement();

            String query = "SELECT\n"
                    + "    u.id,\n"
                    + "    u.name,\n"
                    + "    u.last_name,\n"
                    + "    u.birthday,\n"
                    + "    u.total_hours,\n"
                    + "    u.start_year,\n"
                    + "    u.nickname\n"
                    + "FROM\n"
                    + "    USER AS u\n"
                    + "LEFT JOIN user_event_xref AS xref\n"
                    + "ON\n"
                    + "u.id = xref.user_id\n"
                    + "where xref.event_id = " + eventId;

            rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("last_name"));
                user.setBirthday(rs.getDate("birthday"));
                user.setTotalHours(rs.getInt("total_hours"));
                user.setStartYear(rs.getInt("start_year"));
                user.setNickName(rs.getString("nickname"));

                userList.add(user);
            }
            session.setAttribute("userList", userList);
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }

        return userList;
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
