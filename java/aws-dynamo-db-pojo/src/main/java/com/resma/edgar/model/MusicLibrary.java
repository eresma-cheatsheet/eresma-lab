package com.resma.edgar.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@DynamoDBTable(tableName="music-library")
public class MusicLibrary {

	// Partition Key
	@DynamoDBHashKey(attributeName = "artist-id")
	private String artistId;
	
	// Sort Key
	@DynamoDBRangeKey(attributeName = "artist-name")
	private String artistName;
	
}
