
package services;

import db.DB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ResourceHelper;
import rowmappers.UsersRowMapper;


public class GetUsersForEvent extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        
        String address = "event_users.jsp";
        HttpSession session = request.getSession();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        
        try{
            conn = DB.getConnection();
            String query = ResourceHelper.getResourceText("/sql/getUsersForEvent.sql");
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, eventId);
            
            session.setAttribute("users", UsersRowMapper.mapData(stmt.executeQuery()));
            session.setAttribute("eventId", eventId);
        } catch (SQLException ex) {
            Logger.getLogger(GetUsersForEvent.class.getName()).log(Level.SEVERE, null, ex);
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
