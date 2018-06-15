package services;

import db.DB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.UserEvents;

public class ChangePassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String address = "login.jsp";
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String newPasswordConfirm = request.getParameter("newPasswordConfirm");

        UserEvents userEvents = (UserEvents) session.getAttribute("userEvents");
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        if (oldPassword.equals(newPassword)) {
            session.setAttribute("message", "Stara i nova sifra ne mogu "
                    + "biti iste");
            response.sendRedirect(address);
        }
        if (!newPassword.equals(newPasswordConfirm)) {
            session.setAttribute("message", "Nova sifra i potvrda sifre"
                    + " ne mogu biti iste");
            response.sendRedirect(address);
        }
        try {
            con = DB.getConnection();
            stmt = con.createStatement();

            String query = "Update user set password = '" + newPassword + "'"
                    + "where id=" + userEvents.getId();
            if (stmt.execute(query)) {
                session.setAttribute("message", "Sifra uspesno promenjena");
                response.sendRedirect(address);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
