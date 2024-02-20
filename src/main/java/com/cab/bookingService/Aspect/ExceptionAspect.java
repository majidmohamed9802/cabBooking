package com.cab.bookingService.Aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ExceptionAspect {
	
	public static final Log LOGGER = LogFactory.getLog(ExceptionAspect.class);
	
	@AfterThrowing(pointcut= "execution (* com.cab.bookingService.Service.*Impl.*(..))",throwing = "exception")
	public void bookingExceptionAspect(Exception e) {
		LOGGER.error(e.getMessage(),e);
	}

}
