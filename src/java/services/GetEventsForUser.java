package services;

import db.DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Event;

public class GetEventsForUser extends HttpServlet {

    protected List<Event> processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Event> eventList = new ArrayList<>();

        int userId = Integer.parseInt(request.getParameter("userId"));

        HttpSession session = request.getSession();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT e.id, e.name, e.date, e.start_time, e.end_time,"
                    + " e.hours_duration, e.place"
                    + " FROM EVENT e "
                    + "LEFT JOIN user_event_xref xref"
                    + " ON "
                    + "e.id = xref.event_id "
                    + "WHERE"
                    + " xref.is_deleted = 0 "
                    + "AND e.is_deleted = 0"
                    + " AND xref.user_id = " 
                    + userId;
            rs = stmt.executeQuery(query);
            
            
            while(rs.next())
            {
            }
        } catch (SQLException exc) {
            exc.getMessage();
        }
        
        return eventList;
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
