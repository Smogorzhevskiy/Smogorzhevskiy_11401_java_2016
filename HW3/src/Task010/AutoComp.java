package Task010;

import Task010.Interface.Unit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class AutoComp {


    @After("execution(* *..ElfScout.getInformation())")
    public void initElfScout(JoinPoint point) {
        System.out.println("Aspect");

        ((Unit) point.getThis()).autoCompleteCell();
        System.out.println("Aspect");
    }
}
