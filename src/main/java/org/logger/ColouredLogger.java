package org.logger;

import org.logger.interfaces.Logger;

public class ColouredLogger {
	public void method1(){
		Logger consoleLogger=LoggerFactory.getLogger();
		System.err.println("HelloWorld");
	}
	public void method2(){
		Logger consoleLogger=LoggerFactory.getLogger();
		System.out.println("HelloWorld");
	}
	public static void main(String[] args) {
		Logger consoleLogger=LoggerFactory.getLogger();
		ColouredLogger colouredLogger=new ColouredLogger();
		colouredLogger.method1();
		colouredLogger.method2();
	}
}
