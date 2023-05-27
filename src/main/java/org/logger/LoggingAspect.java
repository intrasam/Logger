package org.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.logger.interfaces.Logger;

@Aspect
public class LoggingAspect {
	private final Logger logger = LoggerFactory.getLogger();

	@Pointcut(value="@annotation(org.logger.interfaces.Monitor)")
	public void logMethodExecution() {}

	@Before("logMethodExecution()")
	public void logMethodEntry(JoinPoint joinPoint) {
		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		logger.log(LogLevel.DEBUG, "Entering method: " + className + "." + methodName, null);
	}
	@After("logMethodExecution()")
	public void logMethodExit(JoinPoint joinPoint) {
		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		logger.log(LogLevel.DEBUG, "Exiting method: " + className + "." + methodName, null);
	}
}
