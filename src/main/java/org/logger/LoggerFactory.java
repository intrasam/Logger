package org.logger;

import org.logger.interfaces.Logger;
public class LoggerFactory {
	public static Logger getLogger() {
		return new ConsoleLogger(LogLevel.DEBUG);
	}

}
