import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogWork {

    @Before("execution(* *..Developer.work())")
    public void loggingWork(JoinPoint jp){
        System.out.println(((Developer) jp.getThis()).getName() + "is ready to work");
    }
}
