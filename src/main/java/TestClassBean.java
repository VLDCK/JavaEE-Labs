
import java.lang.annotation.Annotation;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Stateless;
import javax.ejb.Singleton;

@Stateless
//@Local(TestInterface.class) // можем вызвать интерфейс без его определениня
@LocalBean
public class TestClassBean implements TestInterface {

@Resource(name = "testIntValue")
private int sum;
@Resource(name = "testStringValue")
private String field;

public TestClassBean()
{
    this.sum = 10+5;
    this.field = "Ten + Five";
}
    
    @Override
    public String getTestImplement() {
        return "Its Local ";
    }
    

}
