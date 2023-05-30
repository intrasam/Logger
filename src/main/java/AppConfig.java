import org.logger.ColouredLogger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.logger")
public class AppConfig {
	public static void main(String[] args) {
		ColouredLogger logger = new ColouredLogger();
		logger.method1();
		logger.method2();
	}
}

