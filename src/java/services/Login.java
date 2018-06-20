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
import rowmappers.UserEventSetExtractor;

public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        int userId = 0;
        int isAdmin = 0;
        String address = "index.jsp";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            conn = DB.getConnection();
            stmt = conn.createStatement();

            String query = "SELECT id, password, is_admin "
                    + "FROM user "
                    + "WHERE nickname='" + username + "'";

            rs = stmt.executeQuery(query);

            if (rs.next()) {
                if (password.equals(rs.getString("password"))) {
                    userId = rs.getInt("id");
                    isAdmin = rs.getInt("is_admin");
                    query = "SELECT e.name event_name, e.date, e.start_time, e.end_time,"
                            + " e.hours_duration, e.place, u.id, u.name user_name, u.last_name,"
                            + " u.birthday, u.total_hours,"
                            + "u.start_year, u.nickname"
                            + " FROM EVENT e "
                            + " LEFT JOIN user_event_xref xref"
                            + " ON "
                            + " e.id = xref.event_id "
                            + " LEFT JOIN user u ON"
                            + " xref.user_id=u.id"
                            + " WHERE"
                            + " xref.is_deleted = 0"
                            + " AND e.is_deleted = 0"
                            + " AND u.is_deleted = 0"
                            + " AND xref.user_id = "
                            + userId;

                    rs = stmt.executeQuery(query);

                    session.setAttribute("userEvents", UserEventSetExtractor.mapData(rs));
                    if (isAdmin == 1) {
                        session.setAttribute("adminId", userId);
                        address = "admin.jsp";
                    } else {
                        address = "user.jsp";
                    }
                    System.out.println(address + ": <<<ADRESA");
                } else {
                    session.setAttribute("message", "Pogrešna šifra");
                    System.out.println("Incorrect password");
                }
            } else {
                session.setAttribute("message", "Volonter ne postoji");
                System.out.println("user does not exist");
            }
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
