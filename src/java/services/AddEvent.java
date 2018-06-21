package services;

import db.DB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
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

public class AddEvent extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Connection conn = null;
        Statement stmt = null;

        String name = request.getParameter("name");
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
        } catch (ParseException ex) {
            Logger.getLogger(AddEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        String place = request.getParameter("place");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        int volonteurNumber = Integer.parseInt(request.getParameter("volonteurNumber"));
        float hoursDuration = Float.parseFloat(request.getParameter("hoursDuration"));
        
        try 
        {
            conn = DB.getConnection();
            stmt = conn.createStatement();
            String query = "INSERT INTO event (`name`, `date`, `start_time`,"
                    + " `volonteur_number`, `end_time`, `hours_duration`,"
                    + " `place`, `is_deleted`) VALUES"
                    + " ('"+name+"', '"+date+"', '"+startTime+"', "+volonteurNumber+","
                    + " '"+endTime+"', "+hoursDuration+", '"+place+"', 0);";
          
            if(!stmt.execute(query))
            {
                System.out.println("Event not inserted for event: " + name);
                response.sendRedirect("admin.jsp");
            }else{
                        session.setAttribute("message", "Akcija dodata");
            response.sendRedirect("new_event.jsp");}
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
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
