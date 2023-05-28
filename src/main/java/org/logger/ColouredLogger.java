package org.logger;

import org.logger.interfaces.Monitor;


public class ColouredLogger {
	@Monitor
	public int method1(){
		int x=10;
		int y=20;
		return (x+y);
	}

	public void method2(){
		System.out.println("HelloWorld");
	}
}
