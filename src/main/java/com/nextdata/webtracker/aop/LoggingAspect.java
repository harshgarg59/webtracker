package com.nextdata.webtracker.aop;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger logger=Logger.getLogger(LoggingAspect.class.toString());
	
	@Pointcut("execution(* com.nextdata.webtracker.controller.*.*(..)) || execution(* com.nextdata.webtracker.dao.*.*(..)) execution(* com.nextdata.webtracker.service.*.*(..))")
	public void pointcut() {};
	
	@Before("pointcut()")
	public void beforLogger(JoinPoint  joinPoint) {
		Signature signature = joinPoint.getSignature();
		logger.info("@Before signature :"+signature);
		Object[] args = joinPoint.getArgs();
		logger.info("@Before args :"+Arrays.asList(args));
 	}
	
	@AfterReturning(pointcut = "pointcut()", returning = "result")
	public void afterLogger(JoinPoint joinPoint, Object result ) {
		Signature signature = joinPoint.getSignature();
		logger.info("@AfterReturning signature :"+signature);
		Object[] args = joinPoint.getArgs();
		logger.info("@AfterReturning args :"+Arrays.asList(args));
		
	}
}
