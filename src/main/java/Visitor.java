
import java.util.Set;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.annotation.security.RunAs;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Stateless
@RolesAllowed({"user", "admin"})
@RunAs("inventoryDpt")
public class Visitor {
   @Pattern.List({
       @Pattern(regexp="^[a-A]$"),
       @Pattern(regexp="^[0-9]$")
   }) 
   

  @NotNull(message="<br>Name have to be written")
  @Size(min = 2, message="The name of people must be more than 1 symbol")
  String name;

  @NotNull(message="<br>Lastname have to be written")
  @Pattern(regexp = "^((\\+?380)([0-9]{9}))$",message = "The given phone cannot exist")
 //@Digits(fraction = 0, integer = 10)     
  String phone;

  @NotNull(message="<br>Count Of People must be set")
  @Size(min = 1, message="The number of people must be more than 1")
  String countOfPeople;
  
 
  @DenyAll
  @Override
  public String toString() {
    return String.format("name: [%s], phone: [%s], countOfPeople: [%s]",
        name, phone, countOfPeople);
  }
  @RolesAllowed("admin")
  public String validate(Object object, Validator validator) {
    Set<ConstraintViolation<Object>> constraintViolations = validator
        .validate(object);
    String res="";
    res = object.toString()+'\n';
    res+=String.format("<br>Number of errors: %d", constraintViolations.size())+'\n';
    
    for (ConstraintViolation<Object> cv : constraintViolations)
      res+=String.format(
          "<br>Error! property: [%s], value: [%s], message: [%s]",
          cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage())+'\n';
    return res;
  }
  
  @RolesAllowed("admin")
    public static boolean isValidate(Object object, Validator validator) {
    Set<ConstraintViolation<Object>> constraintViolations = validator
        .validate(object);
    
    
    return constraintViolations.size() > 0 ? false : true ;
  }
}
