package me.flamingo.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author flamingo
 * @create 9/12/21 10:20 PM
 */
@Component
@Aspect
public class Audience {

    @Pointcut("execution(* Performance.perform(..))")
    public void perform(){}

    @Before("perform()")
    public void takeSeats() {
        System.out.println("找到座位做好");
    }

    @Around("perform()")
    public void watchPerformce(ProceedingJoinPoint joinPoint) {
        try {
            String originName = (String) joinPoint.getArgs()[0];
            System.out.println("originName:" + originName);
            Object[] args = {"<上甘岭战役>"};
            joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
