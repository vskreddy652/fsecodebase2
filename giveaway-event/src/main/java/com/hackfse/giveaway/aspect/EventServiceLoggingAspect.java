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
public class EventServiceLoggingAspect {
	private static final Logger LOGGER = LogManager.getLogger(EventServiceLoggingAspect.class);
	
	@Before("execution(* com.hackfse.giveaway.services.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		
		LOGGER.info(joinPoint.toString() +" STARTS...");
	}
	
	@After("execution(* com.hackfse.giveaway.services.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		LOGGER.info(joinPoint.toString() +"  ENDS...");
	}
	
	@AfterReturning(pointcut = "execution(* com.hackfse.giveaway.services.*.*(..))", returning= "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		LOGGER.info(joinPoint.toString() +"  response :::: "+result);
	}
	
	@AfterThrowing(pointcut = "execution(* com.hackfse.giveaway.services.*.*(..))", throwing= "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		LOGGER.info(joinPoint.toString() +"  error :::: "+error);
    }

}
