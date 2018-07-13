package services;

import db.DB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ResourceHelper;

public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        Date birthday = new Date(0);
        try {
            new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"))
                    .toInstant().atZone( ZoneId.of( "Africa/Tunis" )).toLocalDate() ;

        } catch (ParseException ex) {
            System.out.println(ex);
        }
        int startYear = Integer.parseInt(request.getParameter("startYear"));
        String username = request.getParameter("username"); //TODO:// check if username already exist
        String password = request.getParameter("password");
        
        Connection con = null;
        PreparedStatement stmt = null;
        String query = ResourceHelper.getResourceText("/sql/insertNewUser.sql");
        try{
            con = DB.getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, lastName);
            stmt.setDate(3, birthday);
            stmt.setInt(4, startYear);
            stmt.setString(5, password);
            stmt.setString(6, username);
            
            stmt.execute(query);
            
            request.getSession().setAttribute("message", "Korisnik dodat");
            
        } catch (SQLException ex) {
                        request.getSession().setAttribute("message", "Nesto nije u redu,"
                                + " kontaktirajte administratora");
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("index.jsp");
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
