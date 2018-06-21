package services;

import db.DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import rowmappers.UsersRowMapper;

public class GetUsers extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String address = "event_users.jsp";
        
        String query = "SELECT\n"
                + "    u.id,\n"
                + "    u.name,\n"
                + "    u.last_name,\n"
                + "    u.birthday,\n"
                + "    u.total_hours,\n"
                + "    u.start_year,\n"
                + "    u.nickname\n"
                + "FROM\n"
                + "    USER AS u\n";
        try {
            con = DB.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(query);
            
            session.setAttribute("userList", UsersRowMapper.mapData(rs));
            
            response.sendRedirect(address);
        } catch (SQLException ex) {
            Logger.getLogger(GetUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

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
