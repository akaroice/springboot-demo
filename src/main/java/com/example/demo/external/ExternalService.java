package com.example.demo.external;

import com.example.demo.domain.Demo;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by akaroice on 2018. 1. 17..
 */
@Service
public class ExternalService {
	private final RestTemplate restTemplate;

	public ExternalService(ExternalProperties externalProperties, RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder
				.rootUri(externalProperties.getRootUrl())
				.build();
	}

	public Demo call(String name) {
		return this.restTemplate.getForObject("/demo?name={name}", Demo.class, name);
	}
}
