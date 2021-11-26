
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Target;
import javax.ejb.Local;
import javax.inject.Qualifier;
import javax.validation.Constraint;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@NotNull
@Digits(fraction = 0, integer = 10)  
@ReportAsSingleViolation
@Constraint(validatedBy = {})
@Qualifier
@Target({METHOD, FIELD, PARAMETER, TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Local
public @interface Availible {
   
    String getAvailibleRoomsNum();
       
}