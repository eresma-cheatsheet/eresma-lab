package com.resma.edgar.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.boot.logging.DeferredLogFactory;


public class CustomEnvironmentPostProcessor implements EnvironmentPostProcessor {

		private final Log log;
		
		public CustomEnvironmentPostProcessor(DeferredLogFactory deferredLogFactory) {
			this.log = deferredLogFactory.getLog(CustomEnvironmentPostProcessor.class);
		}
	
		@Override
		public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
			log.info("Starting CustomEnvironmentPostProcessor to update properties");
			MutablePropertySources mps = environment.getPropertySources();
			Map<String, Object> rtn = new HashMap<>();
			for(PropertySource<?> ps: mps) {
				if(ps instanceof EnumerablePropertySource) {
					for(String key: ((EnumerablePropertySource) ps).getPropertyNames()) {
						log.info(key + " : " + ps.getProperty(key));
						rtn.put(key, ps.getProperty(key));
					}
				}
			}
			Map<String, Object> prop  = new HashMap<>();
	        prop.put("welcome-message",
	                "Hello World 2.0");
	        environment.getPropertySources().addFirst(new MapPropertySource("MyProperties", prop));
		}

}
