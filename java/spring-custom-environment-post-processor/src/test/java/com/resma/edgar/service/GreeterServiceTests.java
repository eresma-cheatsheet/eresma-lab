package com.resma.edgar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
public class GreeterServiceTests {
	
	@Autowired
	GreeterService greeterService;
	
	@Test
	void greetTest() {
		assertEquals("Hello World 2.0", ReflectionTestUtils.getField(greeterService, "message"));
	}
}
