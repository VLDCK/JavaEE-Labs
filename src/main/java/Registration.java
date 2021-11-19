
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@WebServlet(urlPatterns = {"/Registration"})
public class Registration extends HttpServlet {

    ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
    Validator validator = vf.getValidator();
    
    Visitor visitor = new Visitor();
    
    @Override
    protected void doGet(HttpServletRequest request, 
				HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
    }

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />");                  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public String fullField(HttpServletRequest request)
    {    
        visitor.name = request.getParameter("name");
        visitor.phone = request.getParameter("tel");
        visitor.countOfPeople = request.getParameter("peopleNumber");
        String dayNumber = request.getParameter("daysNumber");
        String path;
       
        
        if(Visitor.isValidate(visitor, validator)){
            path = " ";
        }   
        else
            path = visitor.validate(visitor, validator);
        return path;
    }
      
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        response.addCookie(new Cookie("name", request.getParameter("name")));
        
        String result = fullField(request);
        if(!result.startsWith(" ")) {   
            try {
                writer.println("<h2>" + result + "</h2>");
            } 
            finally {
                writer.close();  
            }
        }
        else{
            response.sendRedirect("/Registration/rooms.html");
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
