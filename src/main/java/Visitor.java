
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ReportAsSingleViolation;
import javax.validation.Validator;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


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
  
  /*@Size(min = 1, message="The number of people must be more than 1")
  @NotNull(message="<br>Count Of People must be set")
  String daysNumber;
*/
  @Override
  public String toString() {
    return String.format("name: [%s], phone: [%s], countOfPeople: [%s]",
        name, phone, countOfPeople);
  }

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
  
  
    public static boolean isValidate(Object object, Validator validator) {
    Set<ConstraintViolation<Object>> constraintViolations = validator
        .validate(object);
    
    
    return constraintViolations.size() > 0 ? false : true ;
  }
}
