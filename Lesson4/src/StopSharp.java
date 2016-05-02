import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.omg.CORBA.Object;

/**
 * Created by User on 09.03.16.
 */

@Aspect
public class StopSharp {

    @Around("execution(* Developer.learnLanguage(*))")
    public Object stopIt(ProceedingJoinPoint jp) throws Throwable{
        String lang = (String) jp.getArgs()[0];
        if ("c#".equals(lang.toLowerCase())){
            System.out.println("Mmmm c#");
            return  null;
        }

        return (Object) jp.proceed();
    }
}
