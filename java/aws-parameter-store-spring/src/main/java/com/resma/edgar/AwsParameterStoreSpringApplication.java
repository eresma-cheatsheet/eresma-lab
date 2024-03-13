package com.resma.edgar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/*
 * Sample project for retrieving values from AWS Parameter Store
 * 
 * AWS CDK is configured in local machine
 * AWS Parameter store is configured with the following
 * 
 * Generic Configuration
 *
 * 	Name: /eresma/aws/welcome-message 
 * 	Value: "Greetings, eresma!"
 * 
 * Profile Specific Configuration
 *
 * 	Name: /eresma/aws_dev/welcome-message 
 * 	Value: "Greetings from dev, eresma!"
 *
 * 	bootstrap.properties
 * 		aws.paramstore.profileSeparator=_
 * 		spring.active.profile = dev
 * 
 */

@SpringBootApplication
@Slf4j
public class AwsParameterStoreSpringApplication implements CommandLineRunner {

    @Value("${welcome-message}")
    private String welcomeMessage;
    
	public static void main(String[] args) {
		SpringApplication.run(AwsParameterStoreSpringApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
        log.info("Retrieved welcome message from Parameter Store: {}", welcomeMessage);
    }

}
