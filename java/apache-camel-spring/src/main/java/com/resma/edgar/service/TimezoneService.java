package com.resma.edgar.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TimezoneService {

	public String getCurrentTime() {
		List<String> zones = Arrays.asList("Canada/Eastern", "Asia/Singapore", "Asia/Dubai");
		StringBuilder sb = new StringBuilder();
		ZonedDateTime currentTime = ZonedDateTime.now();
		for(String zone: zones) {
			sb.append(currentTime.withZoneSameInstant(ZoneId.of(zone))+"'\n");
		}
		return sb.toString();
	}
	
}
