package com.resma.edgar.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest
public class PutServiceTest {

	@SpyBean
	PutService putService;
	
	@Test
	void getItemTest() {
		verify(putService,times(1)).put();
	}
}
