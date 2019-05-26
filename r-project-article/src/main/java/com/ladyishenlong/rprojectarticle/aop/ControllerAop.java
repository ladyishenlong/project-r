package com.ladyishenlong.rprojectarticle.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ruanchenhao
 * @Date 2019-05-26 08:46
 * <p>
 * aop 参考 https://blog.csdn.net/wodetongnian/article/details/80777713
 * aop 也可以注解使用，在需要切入的地方注解
 * 例如：记录重要信息的日志，插入数据库之中，商品交易订单等之类的
 */
@Slf4j
@Component
@Aspect
public class ControllerAop {


    /**
     * 指定切点
     */
    @Pointcut("execution(* com.ladyishenlong.rprojectarticle.controller..*.*(..))")
    public void controller() {
    }


    @Before("controller()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("------------------- aop --------------------");
        log.info("Aop 请求地址：{}", request.getRequestURL());

        Object[] obj = joinPoint.getArgs();//获取目标方法的参数信息

        joinPoint.getThis(); // AOP代理类信息
        joinPoint.getTarget(); // 代理的目标对象
        Signature signature = joinPoint.getSignature(); //  用的最多，通知的签名

        log.info("代理的方法是 ： " + signature.getName()); //  打印 代理的是哪一个方法
        log.info("AOP 代理的名字 ： " + signature.getDeclaringTypeName());
        signature.getDeclaringType();//  AOP代理类的类（class）信息

    }


    @AfterReturning(value = "controller()", returning = "result")
    public void doAfterReturn(Object result) {
        log.info("请求完成，返回结果：{}", result);
    }

    /**
     * 03 . 后置异常通知
     * 定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
     * throwing 限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
     * 对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
     */
    @AfterThrowing(value = "controller()()", throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        // 目标方法名
        System.out.println(joinPoint.getSignature().getName());
        if (exception instanceof NullPointerException) {
            System.out.println("发生了空指针异常");
        }
    }


    /**
     * 环绕通知：
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     */
    @Around("controller()")
    public Object doAroundService(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("环绕通知的目标方法名为 ： " + proceedingJoinPoint.getSignature().getName());
        try {
            Object object = proceedingJoinPoint.proceed();
            return object;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}




