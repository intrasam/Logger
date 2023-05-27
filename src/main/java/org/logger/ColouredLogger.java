package org.logger;

import org.logger.interfaces.Monitor;

public class ColouredLogger {
	@Monitor
	public void method1(){
		System.err.println("HelloWorld");
	}

	public void method2(){
		System.out.println("HelloWorld");
	}
	public static void main(String[] args) {
		ColouredLogger colouredLogger=new ColouredLogger();
		colouredLogger.method1();
		colouredLogger.method2();
	}
}
