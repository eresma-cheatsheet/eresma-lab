package com.resma.edgar.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GetItemService {

	public void getItem() {
		
		HashMap<String, AttributeValue> keyToGet = new HashMap<String, AttributeValue>();
		keyToGet.put("artist-id", new AttributeValue("the1975"));
		keyToGet.put("artist-name", new AttributeValue("The 1975"));
		
		GetItemRequest request = new GetItemRequest()
				.withKey(keyToGet)
				.withTableName("music-library");
		
		final AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.defaultClient();
		GetItemResult result = amazonDynamoDB.getItem(request);
		log.info(result.getItem().toString());
		
	}
}
