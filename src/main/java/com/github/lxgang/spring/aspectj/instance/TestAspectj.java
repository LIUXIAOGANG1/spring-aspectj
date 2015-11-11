package com.github.lxgang.spring.aspectj.instance;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TestAspectj {
	Logger logger = LoggerFactory.getLogger(TestAspectj.class);
	
	@Before("execution(* com.github.lxgang.spring.aspectj.service.impl.TestLoggerImpl.testAround(..))")
	public void logBefore(){
		logger.info("------------------------------test @Before on cn.gmw.skype.aspectj.service.impl.TestLoggerImpl.test()------------------------------");
	}
	
	
	@After("execution(* com.github.lxgang.spring.aspectj.service.impl.TestLoggerImpl.testAround(..))")
	public void logAfter(){
		logger.info("------------------------------test @After on cn.gmw.skype.aspectj.service.impl.TestLoggerImpl.test()------------------------------");
	}
	
	@Around("execution(* com.github.lxgang.spring.aspectj.service.impl.TestLoggerImpl.testAround(..))")
	public Object logAround(ProceedingJoinPoint joinPoint){
		logger.info("------------------------------test @Around on cn.gmw.skype.aspectj.service.impl.TestLoggerImpl.test()------------------------------");
		
		Object[] args = joinPoint.getArgs();
		if(args != null && args.length == 1){
			Object obj = args[0];
			
			logger.info("-----------------------------before-----------------------------:" + (String)obj);
		}
		
		try {
			String[] params = new String[]{"aaaaa"};
			Object result = joinPoint.proceed(params);
			
			logger.info("-----------------------------end-----------------------------:" + (String)result); 
			
			return result;
		} catch (Throwable e) {
			e.printStackTrace();
			logger.info("test Exception. {}", e.getMessage());
			return "";
		}
	}
}
