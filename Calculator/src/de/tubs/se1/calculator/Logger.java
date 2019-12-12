package de.tubs.se1.calculator;

public class Logger {
	
	private static Logger logger = new Logger();
	
	private Logger() {
	}

	public void log(String message) {
		System.err.println(message);
	}

	public static Logger getLogger() {
		return logger;
	}
}
