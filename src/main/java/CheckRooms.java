import java.io.IOException;
import java.io.PrintWriter;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/roomsAV")
public class CheckRooms extends HttpServlet {
    
    
    
    @Inject
    AvailableRooms roomsAv;
    
      
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckRooms</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" /> ");           
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>We Have Availible Rooms : " +roomsAv.getAvailibleRoomsNum()+ "</h1><br>");
            out.println("<h2>Type Of Rooms</br> <br>" +roomsAv.getRooms()+ "</h2>");
            out.println("<form action=\"index.html\" method=\"POST\">\n" +
                        "<br><input type=\"submit\" value=\"Back\"/></br>\n" +
                        "</form>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
       
    }

    
   

}