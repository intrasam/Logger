package org.logger;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.jetbrains.annotations.NotNull;
import org.logger.interfaces.Logger;

import java.lang.reflect.Method;


@Aspect
public class LoggingAspect {
	private final Logger logger = LoggerFactory.getLogger();

	@Pointcut("execution(* (@org.logger.interfaces.Log *).*(..))")
	public void logMethodExecution() {}


	@Before("logMethodExecution()")
	public void logMethodEntry(JoinPoint joinPoint) {
		if (isAlreadyLogged(joinPoint)) {
			String className = joinPoint.getSignature().getDeclaringTypeName();
			String methodName = joinPoint.getSignature().getName();
			logger.log(LogLevel.INFO, "Entering method: " + className + "." + methodName, null);
		}
	}
	@AfterReturning(pointcut="logMethodExecution()", returning="returnValue")
	public void logMethodExit(JoinPoint joinPoint, Object returnValue) {
		if (isAlreadyLogged(joinPoint)) {

			String className = joinPoint.getSignature().getDeclaringTypeName();
			String methodName = joinPoint.getSignature().getName();
			logger.log(LogLevel.INFO, "Exiting method: " + className + "." + methodName + " with return value: " + returnValue, null);
		}
	}
	@AfterThrowing(pointcut="logMethodExecution()", throwing="exception")
	public void logMethodException(JoinPoint joinPoint, Throwable exception) {
		if (isAlreadyLogged(joinPoint)) {

			String className = joinPoint.getSignature().getDeclaringTypeName();
			String methodName = joinPoint.getSignature().getName();
			logger.log(LogLevel.FATAL, "Exception thrown in method: " + className + "." + methodName, exception);
		}
	}
	private boolean isAlreadyLogged(@NotNull JoinPoint joinPoint) {
		// Check for the presence of logging annotations on the class
		Class<?> targetClass = joinPoint.getClass();
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method targetMethod = methodSignature.getMethod();
		if (targetClass.isAnnotationPresent(Slf4j.class) ||
				targetClass.isAnnotationPresent(Log4j.class)){
				//targetClass.isAnnotationPresent(Loggable.class)) {
			return false;
		}

		// Check for the presence of logging annotations on the method

		//targetMethod.isAnnotationPresent(Loggable.class)) {
		return !targetMethod.isAnnotationPresent(Slf4j.class) &&
				!targetMethod.isAnnotationPresent(Log4j.class);
	}

}
