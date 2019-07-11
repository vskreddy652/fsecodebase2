package com.hackfse.agiveawayapp.inventory_management.util;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LoggerUtil {

	final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

	@Before("execution(* com.hackfse.agiveawayapp.inventory_management.controllers..*(..)) || execution(* com.hackfse.agiveawayapp.inventory_management.dao..*(..)) || execution(* com.hackfse.agiveawayapp.inventory_management.services..*(..))")
	public void beforeMethodExecution(JoinPoint jointPoint) {
		final String logString = "Execution started in " + jointPoint.getSignature() + " at time: "
				+ new Date(System.currentTimeMillis()).toString();
		System.out.println(logString);
		printLogInfoToFile(logString);
	}

	@After("execution(* com.hackfse.agiveawayapp.inventory_management.controllers..*(..)) || execution(* com.hackfse.agiveawayapp.inventory_management.dao..*(..)) || execution(* com.hackfse.agiveawayapp.inventory_management.services..*(..))")
	public void afterMethodExecution(JoinPoint jointPoint) {
		final String logString = "Execution completed in " + jointPoint.getSignature() + " at time: "
				+ new Date(System.currentTimeMillis()).toString();
		System.out.println(logString);
		printLogInfoToFile(logString);
	}

	@AfterThrowing(pointcut = "execution(* com.hackfse.agiveawayapp.inventory_management.controllers..*(..)) || execution(* com.hackfse.agiveawayapp.inventory_management.dao..*(..)) || execution(* com.hackfse.agiveawayapp.inventory_management.services..*(..))", throwing = "ex")
	public void exceptionOccurred(JoinPoint joinPoint, Throwable ex) {
		final String logString = 
				"Exception occured in:" + joinPoint.getSignature() + ": " + "Exception occurred is as follows:" + ex;
		System.out.println(logString);
		printLogInfoToFile(logString, ex);
	}

	private void printLogInfoToFile(final String logString) {
		logger.info(logString);
	}

	private void printLogInfoToFile(final String logString, final Throwable ex) {
		logger.error(logString, ex);
	}
}
