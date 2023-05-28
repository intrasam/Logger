package org.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.logger.interfaces.Logger;


@Aspect
public class LoggingAspect {
	private final Logger logger = LoggerFactory.getLogger();

	@Pointcut(value="@annotation(org.logger.interfaces.Log) && !within(org.logger.*)")
	public void logMethodExecution() {}


	@Before("logMethodExecution()")
	public void logMethodEntry(JoinPoint joinPoint) {
		//String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		logger.log(LogLevel.DEBUG, "Entering method: "  + methodName, null);
	}
	@AfterReturning(pointcut="logMethodExecution()", returning="returnValue")
	public void logMethodExit(JoinPoint joinPoint, Object returnValue) {

		String methodName = joinPoint.getSignature().getName();
		logger.log(LogLevel.DEBUG, "Exiting method: "  + methodName + " with return value: " + returnValue, null);
	}
}
