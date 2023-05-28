package org.logger;

import org.logger.interfaces.Log;


public class ColouredLogger {
	@Log
	public int method1(){
		int x=10;
		int y=20;
		return (x+y);
	}

	public void method2(){
		System.out.println("HelloWorld");
	}
}
