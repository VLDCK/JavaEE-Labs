
import java.text.ParseException;
import java.util.Date;
import java.util.Random;
import javax.enterprise.inject.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;




@Path("/RESTful")
public class RESTfulClass 
{
    
   @Path("getText")
   @GET
   public String getTestText(@PathParam("text") String txt)
           throws WebApplicationException

   {
       return "<RESTful>" + "<text>" + txt + "</text>";
   }
   
   
   @Path("setText")
   @PUT
   public String putTestText(@QueryParam("text") String txt)
   throws WebApplicationException{
       return "<RESTful>" + "<text>" + txt + "</text>";
   }
 
}
