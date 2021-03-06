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
public class MailSystemLoggingAspect {
	private static final Logger LOGGER = LogManager.getLogger(MailSystemLoggingAspect.class);
	
	@Before("execution(* com.hackfse.giveaway.controllers.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		LOGGER.info("GenerateReport.generateReportForInventry STARTS...");
	}
	
	@After("execution(* com.hackfse.giveaway.controllers.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		LOGGER.info("GenerateReport.generateReportForInventry ENDS...");
	}
	
	@AfterReturning(pointcut = "execution(* com.hackfse.giveaway.controllers.*.*(..))", returning= "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		LOGGER.info("GenerateReport.generateReportForInventry response :::: "+result);
	}
	
	@AfterThrowing(pointcut = "execution(* com.hackfse.giveaway.controllers.*.*(..))", throwing= "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		LOGGER.info("GenerateReport.generateReportForInventry error :::: "+error);
    }

}
