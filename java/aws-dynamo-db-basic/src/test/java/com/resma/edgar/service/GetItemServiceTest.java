package com.resma.edgar.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest
public class GetItemServiceTest {

	@SpyBean
	GetItemService getItemService;
	
	@Test
	void getItemTest() {
		verify(getItemService,times(1)).getItem();
	}
}
