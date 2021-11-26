
import java.lang.annotation.Annotation;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.interceptor.AroundConstruct;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//@Default
//@RequestScoped

public class Room implements Availible {
    
    
    private int number ;
    
    private String suite;
    
    private String view;
   
    
    
    Room(int number, String view,String suite)
    {
        this.number=number;
        this.suite=suite;
        this.view=view;
    }
    
    
    @Override
    public String toString()
    {
        return "Number: "+ this.number+"<br>"
                + "Suite: "+ this.suite+"<br>"
                + "View: "+this.view+"<br>";
    }

    @Override
    public String getAvailibleRoomsNum() {
         return "Its Local";
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
