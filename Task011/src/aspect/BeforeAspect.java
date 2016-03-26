package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by User on 26.03.16.
 */
@Aspect
public class BeforeAspect {

    @Before("execution(* classes.Client.run(..))")
    public void createBefore(JoinPoint point){
        System.out.println("method " + point.getSignature().getName() + "should create Gamer");
    }

    @After("execution(* classes.Client.run(..))")
    public void createAfter(){
        System.out.println("Gamer was created");
    }

}
