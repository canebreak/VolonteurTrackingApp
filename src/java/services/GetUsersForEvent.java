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
import rowmappers.UsersRowMapper;

public class GetUsersForEvent extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int eventId = Integer.parseInt(request.getParameter("eventId"));

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        HttpSession session = request.getSession();
        String address = "event_users.jsp";

        List<User> userList = new ArrayList<>();

        try {
            con = DB.getConnection();
            stmt = con.createStatement();

            String query = "SELECT\n"
                    + "    u.id,\n"
                    + "    u.name,\n"
                    + "    u.last_name,\n"
                    + "    u.birthday,\n"
                    + "    xref.hours as total_hours,\n"
                    + "    u.start_year,\n"
                    + "    u.nickname\n"
                    + "FROM\n"
                    + "    USER AS u\n"
                    + "LEFT JOIN user_event_xref AS xref\n"
                    + "ON\n"
                    + "    u.id = xref.user_id\n"
                    + "LEFT JOIN EVENT AS e\n"
                    + "ON\n"
                    + "    xref.event_id = e.id\n"
                    + "WHERE\n"
                    + "    xref.is_deleted = 0 AND "
                    + "e.is_deleted = 0 AND "
                    + "xref.event_id ="+eventId;

            rs = stmt.executeQuery(query);

            session.setAttribute("userList", UsersRowMapper.mapData(rs));
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }

        response.sendRedirect(address);
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
