package com.resma.edgar.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;
import software.amazon.awssdk.services.ssm.model.SsmException;

@Service
@Slf4j
public class ParameterService {

	@Value("${parameter-name}")
	private String paraName;
	

	/*
	 * https://github.com/awsdocs/aws-doc-sdk-examples/blob/main/javav2/example_code/ssm/src/main/java/com/example/ssm/GetParameter.java
	 */
    public void getParaStoreValue() {
    	
        Region region = Region.of("us-east-2");
        SsmClient ssmClient = SsmClient.builder()
                .region(region)
                .build();

        try {
            GetParameterRequest parameterRequest = GetParameterRequest.builder()
                    .name(paraName)
                    .build();

            GetParameterResponse parameterResponse = ssmClient.getParameter(parameterRequest);
            log.info("Retrieved value from paramater store {}", parameterResponse.parameter().value());

        } catch (SsmException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } finally {
            ssmClient.close();
        }
    }
	
}
