/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.resma.edgar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.resma.edgar.service.GetItemService;
import com.resma.edgar.service.PutService;

@SpringBootApplication
public class AwsDynamoDbApplication implements CommandLineRunner {

	@Autowired
	PutService putService;
	
	@Autowired
	GetItemService getItemService;
	
	@Override
	public void run(String... args) {
		putService.put();
		getItemService.getItem();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AwsDynamoDbApplication.class, args);
	}
}
