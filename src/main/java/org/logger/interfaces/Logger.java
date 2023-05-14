package org.logger.interfaces;

import org.logger.LogLevel;

public interface Logger {
	void log(LogLevel level, String message, Throwable throwable);

}