package com.example.demo.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by coupang on 2018. 1. 12..
 */
@Configuration
public class CustomConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	public ObjectMapper objectMapper() {
//		Mapper instances are fully thread-safe provided that ALL configuration of the
//		instance occurs before ANY read or write calls.
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		return objectMapper;
	}


}
