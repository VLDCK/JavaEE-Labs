
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Target;
import javax.inject.Qualifier;
import javax.validation.ReportAsSingleViolation;

/**
 *
 * @author User
 */

@Qualifier
@Target({METHOD, FIELD, PARAMETER, TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface Availible {
   
    String getAvailibleRoomsNum();
       
}