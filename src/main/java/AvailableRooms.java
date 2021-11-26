
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Default
@RequestScoped
@Named("availibleRoomsNamed")
@Availible(getAvailibleRoomsNum = "0")
public class AvailableRooms { 

    
    private ArrayList<Room> rooms;
    @NotNull(message="Count of rooms should have more than 0")
    @Min(0)
    private int avalibleRoomsNum;
    
    /*@Inject
    public AvailableRooms()
    {
        this.rooms = new ArrayList();
        rooms.add(new Room(531,"President Suite","Ocean View"));
        rooms.add(new Room(412,"President Suite","Mountine View"));
        rooms.add(new Room(361,"Junior Suite ","City View"));
        rooms.add(new Room(136,"Comfort Studio","Forest View"));
    }
    */
    //@PostConstruct
    public void setAvailibleRoomNum()
    {
        avalibleRoomsNum = rooms.size();
    }
    
    
    public String getAvailibleRoomsNum() {
        return String.valueOf(avalibleRoomsNum); 
    }
    
    
    
    public String getRooms() {
        String showListStr="";
        for (Room it : rooms)
        {
            showListStr+=it.toString()+"<br><br>";
        }
        return showListStr;
         
    }
    
}
    
    
    
    

/*
@Inject
    public AvailableRooms()
    {
        
  
    }
       
    
    
    
}
*/
    