package org.logger;

import lombok.extern.slf4j.Slf4j;
import org.logger.interfaces.Log;

@Log
@Slf4j
public class ColouredLogger {
	public int method1(){
		int x=10;
		int y=20;
		return (x+y);
	}

	public void method2(){
		System.out.println("HelloWorld");
	}
}
