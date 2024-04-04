package com.resma.edgar.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GreeterService {

	@Value("${welcome-message}")
	private String message;
	
	public void greet() {
		log.info("Message from Greeter Service: {}", message);
	}
	
}
