
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;

@Startup
@Singleton
public class TestClassLock implements TestInterface{
    
@Resource(name = "testIntValue")
private int sum;

@Resource(name = "testStringValue")
private String field;


public TestClassLock()
{
    this.sum = 10+2;
    this.field = "Ten + Two";
}
    @Lock(LockType.READ)
    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
    @Override
    public String getTestImplement() {
        
        return field+" "+String.valueOf(sum);
    }
    
    @Timeout
    public String programmTimout(Timer timer) {
       return timer.getInfo().toString();
    }
    
}
