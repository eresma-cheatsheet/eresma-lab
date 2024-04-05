package com.resma.edgar.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PutService {

	public void put() {
		
		HashMap<String, AttributeValue> itemValues = new HashMap<String, AttributeValue>();
		itemValues.put("artist-id", new AttributeValue("the1975"));
		itemValues.put("artist-name", new AttributeValue("The 1975"));
		
		final AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.defaultClient();
		amazonDynamoDB.putItem("music-library", itemValues);
		log.info("Item has beed put in Amazon Dynamo DB: {}", itemValues);
		
	}
}
