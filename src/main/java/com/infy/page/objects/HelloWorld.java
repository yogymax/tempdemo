package com.infy.page.objects;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class HelloWorld {
	
	//OFE WI DTA
	
	public static Logger log = Logger.getLogger(HelloWorld.class);
	
	public static void main(String[] args) {
		//o -- Off
		log.setLevel(Level.DEBUG);
		
		log.fatal("This is fatal message");
		log.error("This is error message");
		log.warn("This is warn message");
		log.info("This is info message");
		log.debug("This is debug message");
		log.trace("This is trace message");
		//A 
	}
}
