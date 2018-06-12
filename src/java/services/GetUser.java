package services;

import db.DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

public class GetUser extends HttpServlet {

    protected User processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("userId"));

        HttpSession session = request.getSession();

        User user = new User();
                
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DB.getInstance().getConnection();
            
            stmt = conn.createStatement();
            
            String query = "Select id, name, last_name, birthday, total_hours, "
                    + "start_year, nickname"
                    + "from users"
                    + "where id ="+userId;
            
            rs = stmt.executeQuery(query);
            if(rs.next())
            {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("last_name"));
                user.setTotalHours(rs.getInt("total_hours"));
                user.setStartYear(rs.getInt("start_year"));
                user.setNickName(rs.getString("nickname"));
            }
        } catch (SQLException exc) {
            exc.getMessage();
        }
        
        return user;
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
