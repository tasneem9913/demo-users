package com.user.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Configuration {
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
