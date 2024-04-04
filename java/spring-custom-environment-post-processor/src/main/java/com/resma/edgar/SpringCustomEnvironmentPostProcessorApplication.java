package com.resma.edgar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.resma.edgar.service.GreeterService;

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
public class SpringCustomEnvironmentPostProcessorApplication implements CommandLineRunner {

	@Autowired
	GreeterService greeterService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCustomEnvironmentPostProcessorApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
		greeterService.greet();
    }

}
