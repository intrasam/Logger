package org.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.logger.interfaces.Logger;

@Aspect
public class LoggingAspect {
	private final Logger logger = LoggerFactory.getLogger();

	@Pointcut("execution(* *.*(..))")
	public void logMethodExecution() {}

	@Before("logMethodExecution()")
	public void logMethodEntry(JoinPoint joinPoint) {
		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		logger.log(LogLevel.DEBUG, "Entering method: " + className + "." + methodName, null);
	}
}
