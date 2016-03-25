package Task012;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 24.03.16.
 */

@Aspect
public class StopInjection {
    private Pattern p = Pattern.compile(".*(select|drop|database|table|from).*");

    Matcher m;

    public StopInjection() {

    }

    @Around("execution(* *..*.execute(String))")
    public Object StopInjection(ProceedingJoinPoint point) throws Throwable {
        System.out.println("Check.....");
        String injection = (String) point.getArgs()[0];
        m = p.matcher(injection);
        if (m.lookingAt()) {
            System.out.println("Found: sql injection");
            return null;
        } else {
            return point.proceed();
        }
    }
}
