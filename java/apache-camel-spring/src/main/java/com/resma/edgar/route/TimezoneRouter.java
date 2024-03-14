package com.resma.edgar.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resma.edgar.service.TimezoneService;

@Component
public class TimezoneRouter extends RouteBuilder {

	@Autowired
	TimezoneService timezoneService;
	
	@Override
	public void configure() throws Exception {
		from("timer:tmzRouter?period=10000")
        .bean(timezoneService, "getCurrentTime")
        .to("stream:out");
	}
}
