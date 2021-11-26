/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.ejb.Timer;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author User
 */
@WebServlet(urlPatterns = {"/ValidationServlet"})
public class ValidationServlet extends HttpServlet {

    @EJB
    TestInterface testInterfacee;
    
    //@EJB
    //TestClassBean testbean;
    
    
    @EJB
    TestClassLock testbeanTwo;
    Timer timer ;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter writer = response.getWriter();
            String str = testInterfacee.getTestImplement();
            writer.write(str);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter writer = response.getWriter();
            String str = testInterfacee.getTestImplement();
            writer.write(str+"\n");
            Timer timer = null ;
            str = testbeanTwo.programmTimout(timer);
            writer.write(str);
            
        
        
    }

    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidationServlet </h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }*/
    

    
    

   
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }

}
