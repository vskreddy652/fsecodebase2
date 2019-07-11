package com.hackfse.agiveawayapp.login_register.util;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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
	
	@Before("execution(* com.hackfse.agiveawayapp.login_register.controllers..*(..)) || execution(* com.hackfse.agiveawayapp.login_register.dao..*(..)) || execution(* com.hackfse.agiveawayapp.login_register.services..*(..))")
	public void beforeMethodExecution(JoinPoint jointPoint) {
		final String logString = "Execution started in " + jointPoint.getSignature() + " at time: "
				+ new Date(System.currentTimeMillis()).toString();
		System.out.println(logString);
		printLogInfoToFile(logString);
	}

	@After("execution(* com.hackfse.agiveawayapp.login_register.controllers..*(..)) || execution(* com.hackfse.agiveawayapp.login_register.dao..*(..)) || execution(* com.hackfse.agiveawayapp.login_register.services..*(..))")
	public void afterMethodExecution(JoinPoint jointPoint) {
		final String logString = "Execution completed in " + jointPoint.getSignature() + " at time: "
				+ new Date(System.currentTimeMillis()).toString();
		System.out.println(logString);
		printLogInfoToFile(logString);
	}
	
	private void printLogInfoToFile(final String logString) {
		logger.info(logString);
	}
}
