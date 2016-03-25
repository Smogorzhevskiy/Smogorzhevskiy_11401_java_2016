package Task013;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Aspect
public class AspectCheck {
    private Pattern p;
    Matcher m;

    AspectCheck() {
        p = Pattern.compile("[0-9a-zA-Z]+(@{1}(mail|gmail)\\.(com|ru))");
    }

    @Around("execution(* *..User.setMail(..))")
    public Object testMail(ProceedingJoinPoint point) throws Throwable {
        System.out.println("ooo");
        String temp = (String) point.getArgs()[0];
        m = p.matcher(temp);
        if (m.matches()) {
            point.proceed();
        } else {
            System.out.println("bad email");
            return null;

        }
        return point.proceed();
    }

}
