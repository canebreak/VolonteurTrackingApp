package services;

import db.DB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        DB db = DB.getInstance();
        Connection con = null;
        Statement stmt = null;

        String address = "login.jsp";
        HttpSession session = request.getSession();

        String birthday = request.getParameter("birthday");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);

        User user = new User();
        user.setName(request.getParameter("name"));
        user.setLastName(request.getParameter("lastName"));
        user.setBirthday(date);
        user.setStartYear(Integer.parseInt(request.getParameter("startYear")));
        user.setNickName(request.getParameter("nickName"));
        user.setPassword(request.getParameter("password"));


        System.out.println(user);
        try {
            con = db.getConnection();
            stmt = con.createStatement();
            //TODO: Date is inserted as zeroes check THIS
            String query = "INSERT INTO user (id, name, last_name, birthday,"
                    + " total_hours, start_year, password, isDeleted, isAdmin, nickname)"
                    + " VALUES ('" + user.getName() + "', '" + user.getLastName() + "'"
                    + ",'" + user.getBirthday() + "', 0, " + user.getStartYear() + ","
                    + " '" + user.getPassword() + "', 0, 0, '" + user.getNickName() + "')";

            System.out.println(query);
            if (stmt.execute(query)) {
                response.sendRedirect(address);
            } else {
                address = "index.jsp";
                session.setAttribute("message", "Nesto se desilo pokusajte kasnije");
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }
        db.putConnection(con);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
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
