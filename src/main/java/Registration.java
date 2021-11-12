
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

@WebServlet(urlPatterns = {"/Registration"})

public class Registration extends HttpServlet {

   
    
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
        String path;
        String name = request.getParameter("name");
        String number = request.getParameter("tel");
        String countOfPeople = request.getParameter("peopleNumber");
        String countOfDay=request.getParameter("daysNumber");
        if( name==""|| number.length()!=15 ||countOfPeople=="0"||countOfPeople=="")
            path = request.getContextPath()+ "/NotFoundPage";
        else
            path = request.getContextPath()+ "/rooms.html";
        return path;
    }
      
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.addCookie(new Cookie("name", request.getParameter("name")));
        response.sendRedirect(fullField(request));
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
