package com.hackfse.giveaway.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class EventManagementLoggingAspect {
	private static final Logger LOGGER = LogManager.getLogger(EventManagementLoggingAspect.class);
	
	@Before("execution(* com.hackfse.giveaway.controller.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		LOGGER.info(joinPoint.toString()+" STARTS...");
	}
	
	@After("execution(* com.hackfse.giveaway.controller.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		LOGGER.info(joinPoint.toString()+" ENDS...");
	}
	
	@AfterReturning(pointcut = "execution(* com.hackfse.giveaway.controller.*.*(..))", returning= "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		LOGGER.info(joinPoint.toString()+"  response :::: "+result);
	}
	
	@AfterThrowing(pointcut = "execution(* com.hackfse.giveaway.controller.*.*(..))", throwing= "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		LOGGER.info(joinPoint.toString()+" error :::: "+error);
    }

}
