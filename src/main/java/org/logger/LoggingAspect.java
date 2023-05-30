package org.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.logger.interfaces.Logger;

@Aspect
public class LoggingAspect {
	private final Logger logger = LoggerFactory.getLogger();

	@Pointcut("@annotation(org.logger.interfaces.Log) || @within(org.logger.interfaces.Log)")
	public void logMethodExecution() {}

	@Before("logMethodExecution()")
	public void logMethodEntry(JoinPoint joinPoint) {

			String className = joinPoint.getSignature().getDeclaringTypeName();
			String methodName = joinPoint.getSignature().getName();
			logger.log(LogLevel.INFO, "Entering method: " + className + "." + methodName, null);

	}

	@AfterReturning(pointcut = "logMethodExecution()", returning = "returnValue")
	public void logMethodExit(JoinPoint joinPoint, Object returnValue) {

			String className = joinPoint.getSignature().getDeclaringTypeName();
			String methodName = joinPoint.getSignature().getName();
			logger.log(LogLevel.INFO, "Exiting method: " + className + "." + methodName + " with return value: " + returnValue, null);

	}

	@AfterThrowing(pointcut = "logMethodExecution()", throwing = "exception")
	public void logMethodException(JoinPoint joinPoint, Throwable exception) {

			String className = joinPoint.getSignature().getDeclaringTypeName();
			String methodName = joinPoint.getSignature().getName();
			logger.log(LogLevel.FATAL, "Exception thrown in method: " + className + "." + methodName, exception);

	}

}
