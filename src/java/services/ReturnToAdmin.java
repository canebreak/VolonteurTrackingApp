package services;

import db.DB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Event;
import models.ResourceHelper;
import models.User;
import rowmappers.EventsRowMapper;
import rowmappers.UserRowMapper;

public class ReturnToAdmin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String address = "admin.jsp";
        User user = (User) session.getAttribute("user");

        try {
            //get user
            con = DB.getConnection();
            stmt = con.prepareStatement(ResourceHelper.getResourceText("/sql/getUserByUsername.sql"));
            stmt.setString(1, user.getUsername());

            rs = stmt.executeQuery();
            user = UserRowMapper.mapData(rs);

            session.setAttribute("user", user);
            //get user events
            stmt = con.prepareStatement(ResourceHelper.getResourceText("/sql/getUserEvents.sql"));
            stmt.setInt(1, user.getId());
            rs = stmt.executeQuery();

            List<Event> events = EventsRowMapper.mapData(rs);

            session.setAttribute("userEvents", events);
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
