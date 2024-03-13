package com.resma.edgar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.resma.edgar.service.ParameterService;


/*
 * Sample project for retrieving values from AWS Parameter Store
 * 
 * AWS CDK is configured in local machine
 * AWS Parameter store is configured with the following
 *
 * 	Name: /eresma/aws/welcome-message 
 * 	Value: "Greetings, eresma!"
 *
 * 	application.properties
 * 		parameter-name=/eresma/aws/welcome-message
 * 
 */

@SpringBootApplication
public class AwsParameterStoreApplication implements CommandLineRunner {
    
	
	@Autowired
	public ParameterService parameterService;
	
	public static void main(String[] args) {
		SpringApplication.run(AwsParameterStoreApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {

		parameterService.getParaStoreValue();
    }

	
}
