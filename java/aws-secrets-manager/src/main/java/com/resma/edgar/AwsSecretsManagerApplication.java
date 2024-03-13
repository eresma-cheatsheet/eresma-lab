package com.resma.edgar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.resma.edgar.service.SecretsManagerService;

/*
 * Sample project for retrieving values from AWS Secret Manager
 * 
 * AWS CDK is configured in local machine
 * AWS Secret Managaer is configured with the following
 *
 * 	Secret Name: /eresma/aws/ 
 * 	Secret Value: "welcome-message": "Greetings, eresma!"
 *
 * 	application.properties
 * 		parameter-name=/eresma/aws/welcome-message
 * 
 */

@SpringBootApplication
public class AwsSecretsManagerApplication implements CommandLineRunner {
    
	@Autowired
	public SecretsManagerService secretsManagerService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(AwsSecretsManagerApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {

		secretsManagerService.getSecret();

    }

}
