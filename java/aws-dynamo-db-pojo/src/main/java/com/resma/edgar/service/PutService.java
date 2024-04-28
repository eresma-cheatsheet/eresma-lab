package com.resma.edgar.service;

import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.resma.edgar.model.MusicLibrary;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PutService {

	public void put() {
			
		final AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.defaultClient();
		
		DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
		
		MusicLibrary musicLibray = new MusicLibrary();
		musicLibray.setArtistId("johnMayer");
		musicLibray.setArtistName("John Mayer");
		dynamoDBMapper.save(musicLibray);
		
		log.info("Item has beed put in Amazon Dynamo DB: {}", musicLibray);
		
	}
}
