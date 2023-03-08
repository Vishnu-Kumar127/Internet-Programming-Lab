/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise_7;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VISHNU KUMAR M.J
 */
public class namesort extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String a[]=new String[10];
        int b[]=new int[10];
        for(int i=0;i<7;i++)
        {
            a[i]=request.getParameter("c"+(i+1));
            b[i]=Integer.parseInt(request.getParameter("p"+(i+1)));
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet namesort</title>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Name Sort</h1>");
            out.println("<table> "); 
            out.println("<tr>");
            out.println("<th>Cities Name</th>");
            out.println("<th>Population</th>"); 
            out.println("</tr>");
     
            for(int i=0;i<7;i++)
            {
                for(int j=i+1;j<7;j++)
                {
                    if(a[i].compareTo(a[j])>0)
                    {
                        String temp=a[i];
                        a[i]=a[j];
                        a[j]=temp;
                        
                        int te=b[i];
                        b[i]=b[j];
                        b[j]=te;
                    }
                }
            }
             for(int i=0;i<7;i++)
            {
                out.println("<tr>");
                out.println("<td>"+a[i]+"</td>");
                out.println("<td>"+b[i]+"</td>");
                out.println("</tr>");
            }
            out.println("</table> ");
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
