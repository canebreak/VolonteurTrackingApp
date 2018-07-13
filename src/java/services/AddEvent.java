package services;

import db.DB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Event;
import models.ResourceHelper;

public class AddEvent extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Event event = new Event();
        HttpSession session = request.getSession();
        Connection con = null;
        PreparedStatement stmt = null;
        String address = "admin.jsp";

        String query = ResourceHelper.getResourceText("/sql/addEvent.sql");

        String startDate = request.getParameter("date");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
        java.util.Date date = null;
        try {

            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
            Logger.getLogger(AddEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

        event.setName(request.getParameter("name"));
        event.setDate(sqlStartDate);
        event.setPlace(request.getParameter("place"));
        event.setStartTime(request.getParameter("startTime"));
        event.setEndTime(request.getParameter("endTime"));

        event.setDurationInHours(Float.parseFloat(
                request.getParameter("hoursDuration")));

        try {
            con = DB.getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, event.getName());
            stmt.setDate(2, event.getDate());
            stmt.setString(3, event.getStartTime());
            stmt.setString(4, event.getEndTime());
            stmt.setFloat(5, event.getDurationInHours());
            stmt.setString(6, event.getPlace());

            stmt.execute();
            
            session.setAttribute("message", "Akcija dodata");

        } catch (SQLException ex) {
            address = "new_event.jsp";
            session.setAttribute("message", "Akcija nije dodata");
            Logger.getLogger(AddEvent.class.getName()).log(Level.SEVERE, null, ex);
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
