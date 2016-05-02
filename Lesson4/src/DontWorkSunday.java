import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * Created by User on 09.03.16.
 */

@Aspect
public class DontWorkSunday {

    @Around("execution(* Developer.work())")
    public Object stopIt(ProceedingJoinPoint jp) throws Throwable{
        if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.SUNDAY){
            System.out.println("Dont work");

        } else
        return jp.proceed();
        return  null;
    }
}
