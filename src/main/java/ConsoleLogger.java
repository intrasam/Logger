import java.util.Date;

public class ConsoleLogger implements Logger {
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_CYAN = "\u001B[36m";
	private static final String ANSI_PURPLE = "\u001B[35m";

	private final LogLevel logLevel;

	public ConsoleLogger(LogLevel logLevel) {
		this.logLevel = logLevel;
	}

	@Override
	public void log(LogLevel level, String message, Throwable throwable) {
		if (level.ordinal() < logLevel.ordinal()) {
			return;
		}

		String color = switch (level) {
			case DEBUG -> ANSI_CYAN;
			case INFO -> ANSI_GREEN;
			case WARNING -> ANSI_YELLOW;
			case ERROR -> ANSI_PURPLE;
			case FATAL -> ANSI_RED;
		};

		String formattedMessage = String.format("%s[%s] [%s] %s%s",
				color, new Date(), level, message, ANSI_RESET);

		if (throwable != null) {
			formattedMessage += String.format("%s%s%s",
					System.lineSeparator(), throwable.getMessage(), System.lineSeparator());
		}

		System.out.println(formattedMessage);
	}
}