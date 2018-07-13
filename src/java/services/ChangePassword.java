package services;

import db.DB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ResourceHelper;
import models.User;

public class ChangePassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        String address = "Logout";

        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String newPasswordConfirm = request.getParameter("newPasswordConfirm");

        Connection con = null;
        PreparedStatement stmt = null;

        if (oldPassword.equals(newPassword)) {
            session.setAttribute("message", "Sifre su iste");
        } else if (!newPassword.equals(newPasswordConfirm)) {
            session.setAttribute("message", "Potvrdna sifra nije ista");
        } else {

            try {
                con = DB.getConnection();
                String query = ResourceHelper.getResourceText("/sql/changePassword.sql");
                stmt = con.prepareStatement(query);
                stmt.setString(1, newPassword);
                stmt.setInt(2, user.getId());

                stmt.execute();

            } catch (SQLException ex) {
                address = "change_password.jsp";
                Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect(address);
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
