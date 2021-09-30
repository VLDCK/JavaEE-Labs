/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Rooms"})
public class Rooms extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try (PrintWriter out = response.getWriter()) {
            
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html");
         
        Cookie[] cookies = request.getCookies();
        String cookieName = "name";
        Cookie cookie = null;
        if(cookies !=null) {
            for(Cookie c: cookies) {
                if(cookieName.equals(c.getName())) {
                    cookie = c;
                    break;
                }
            }
        }

        PrintWriter out = response.getWriter();
         String apparts = request.getParameter("apparts");
        
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Rooms</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />"); 
            out.println("<h3>Thank you "+ cookie.getValue() +" for choosing of " + apparts + " apparts in our holet.</h3>");
            out.println("<h2>Please, wait for call in 15 minutes to confirm your order.</h2>");
            out.println("</body>");
            out.println("</html>");
            
            
        } finally {
            out.close();  
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
