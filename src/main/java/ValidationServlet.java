/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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

    
    ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
    Validator validator = vf.getValidator();
    
    Visitor visitor = new Visitor();
    
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
	 visitor.name = request.getParameter("fn");
        // user. = request.getParameter("ln");
         //user.firstname = request.getParameter("fn");
        
        try {
            writer.println("<h2>Firstname: " + visitor.validate(visitor, validator) + "</h2>");
        } 
        catch(Exception e)
        {
            writer.println(e.getMessage());
        }
        finally {
            writer.close();  
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
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
    }
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }

}
