package com.wang.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author WangKanYou
 * @Date 2022/8/17 11:36
 * @描述:
 */
@Component
@Aspect
public class AvoidRepeatSubmitAspect {
    @Pointcut(value = "@annotation(com.wang.web.annotation.AvoidRepeatSubmit)")
    public void point(){
        System.out.println("point()");
    }

    /**
     * @Before 在切点方法之前执行
     *
     * @After 在切点方法之后执行
     *
     * @AfterReturning 切点方法返回后执行
     *
     * @AfterThrowing 切点方法抛异常执行
     *
     * @Around 属于环绕增强，能控制切点执行前，执行后
     *
     */
    @Before(value = "@annotation(com.wang.web.annotation.AvoidRepeatSubmit)")
    public void doAround1(){
        System.out.println("doAround1()");
    }
    @After(value = "point()")
    public void doAround2(){
        System.out.println("doAround2()");
    }
    @AfterReturning(value = "point()")
    public void doAround3(){
        System.out.println("doAround()3");
    }
    @AfterThrowing(value = "point()")
    public void doAround4(){
        System.out.println("doAround4()");
    }
    @Around(value = "point()")
    public Object doAround5(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] objects = new Object[]{2,"dd"};
        Object proceed = joinPoint.proceed();
        return proceed;
    }

}
