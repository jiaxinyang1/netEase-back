package com.hakurei.interception;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

/**
 * @ClassName AOPDemo
 * @Description TODO
 * @Author hakurei
 * @Date 2019/3/4
 * @Version 1.0
 */
@Aspect
@Component
public class AOPDemo {

    @Pointcut("execution(public * com.hakurei.util.RsaEncrypt.*(..))")
    public void  excudeService(){

    }
    @Before("excudeService()")
    public void  test(){
        System.out.println("执行了切面");
    }
}
