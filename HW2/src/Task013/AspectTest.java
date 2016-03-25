package Task013;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by User on 21.03.16.
 */
@Aspect
public class AspectTest {
    @Before("execution(* * .. User.setMail(..))")
    public boolean testMail(JoinPoint point) {
        String temp = (String) point.getArgs()[0];
        System.out.println("temp: " + temp);
        return false;
    }

}
