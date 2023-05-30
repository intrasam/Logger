
import org.logger.ColouredLogger;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
public class TestAspectJ {
	public static void test() {
		System.out.println("test");
	}

	public static void main(String[] args) {
		TestAspectJ.test();
		ColouredLogger cl = new ColouredLogger();
		cl.method1();
		cl.method2();

	}
}
