package com.resma.edgar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.resma.edgar.model.MusicLibrary;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GetItemService {

	public void getItem() {
		
		MusicLibrary musicLibrary = new MusicLibrary();
		musicLibrary.setArtistId("johnMayer");
		
		final AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.defaultClient();
		
		DynamoDBQueryExpression<MusicLibrary> dynamoDBQueryExpression = new DynamoDBQueryExpression<MusicLibrary>();
		dynamoDBQueryExpression.withHashKeyValues(musicLibrary);
		DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
		
		List<MusicLibrary> response = dynamoDBMapper.query(MusicLibrary.class, dynamoDBQueryExpression);
		
		for(MusicLibrary item: response) {
			log.info("Item has beed put in Amazon Dynamo DB: {}", item.toString());
		}
		
	}
}
