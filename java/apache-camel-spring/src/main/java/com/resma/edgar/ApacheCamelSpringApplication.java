package com.resma.edgar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 *	Sample project for using Apache Camel
 *
 *	Time Zone Router
 *		TimezoneRouter is used to route from a timer to stream out. 
 *		Every 10 seconds a call TimezoneService gets the current time
 *		for three different time zones that gets sent to stream output.
 * 
 */
@SpringBootApplication
public class ApacheCamelSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApacheCamelSpringApplication.class, args);
	}

}
