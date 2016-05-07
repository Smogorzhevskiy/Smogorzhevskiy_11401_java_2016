package com.smogorzhevskiy.logger;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;
import java.util.Date;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by User on 07.05.16.
 */
@Aspect
public class InfoLog {
    private static Logger log = Logger.getLogger(InfoLog.class);

    public void before() {
        log.info("\n----" + new Date() + "----\n");
    }

    public void logInfo(ProceedingJoinPoint joinPoint) throws Throwable {
        before();
        System.out.println("Start"
                + joinPoint.getTarget().getClass().getSimpleName()
                + "."
                + joinPoint.getSignature().getName()
                + " with params "
                + Arrays.toString(joinPoint.getArgs()));
    }

}

