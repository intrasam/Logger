package org.logger;

public class ColouredLogger {
	public static void main(String[] args) {
		ConsoleLogger consoleLogger = new ConsoleLogger(LogLevel.DEBUG);
		consoleLogger.log(LogLevel.DEBUG, "Hello World",null);
		consoleLogger.log(LogLevel.INFO, "Hello World",null);
		consoleLogger.log(LogLevel.WARNING, "Hello World",null);
		consoleLogger.log(LogLevel.ERROR, "Hello World",null);
		consoleLogger.log(LogLevel.FATAL, "Hello World",null);
		Logger logger= LoggerFactory.getLogger();
		logger.log(LogLevel.DEBUG, "Hello World",null);
	}
}
