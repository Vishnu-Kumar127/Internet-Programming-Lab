package Exercise_8;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author VISHNU KUMAR M.J
 */
public class Reservation_servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        
        String name = request.getParameter("name");
		int seats = Integer.parseInt(request.getParameter("seats"));
		
		HttpSession session = request.getSession();
		int availableSeats = 50;
		int reservedSeats = 0;
		if(session.getAttribute("availableSeats") != null && session.getAttribute("reservedSeats") != null) {
			availableSeats = (int) session.getAttribute("availableSeats");
			reservedSeats = (int) session.getAttribute("reservedSeats");
		}
		if(seats > availableSeats) {
			response.getWriter().write("Sorry, only " + availableSeats + " seats are available.");
			return;
		}
		availableSeats -= seats;
		reservedSeats += seats;
		session.setAttribute("availableSeats", availableSeats);
		session.setAttribute("reservedSeats", reservedSeats);
		
		Cookie cookie = new Cookie("name", name);
		response.addCookie(cookie);
        
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Seat Reservation</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Reservation Details</h1>");
            out.println("<p>Name: " + name + "</p>");
            out.println("<p>Number of Seats Reserved: " + seats + "</p>");
            out.println("<p>Total Seats Available: " + availableSeats + "</p>");
            out.println("<p>Total Seats Reserved: " + reservedSeats + "</p>");
            out.println("</body>");
            out.println("</html>");
            
            
            
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
